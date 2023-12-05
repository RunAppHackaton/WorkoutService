package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.ProfileServiceClient;
import com.runapp.workoutservice.model.IntervalModel;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.repository.*;
import com.runapp.workoutservice.service.serviceTemplate.RunPlanService;
import com.runapp.workoutservice.service.runPlanService.Interval;
import com.runapp.workoutservice.service.runPlanService.RunTraining;
import com.runapp.workoutservice.utill.existHandler.ExistEnum;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RunPlanServiceImpl implements RunPlanService {
    private final RunPlanRepository runPlanRepository;
    private final RunTypeRepository runTypeRepository;
    private final StageRepository stageRepository;
    private final ExistHandlerRegistry existHandlerRegistry;

    @Override
    public RunPlanModel add(RunPlanModel entity) {
        existHandlerRegistry.handleRequest(ExistEnum.USER, entity.getUserId());
        throw new NoEntityFoundException("User with id: " + entity.getUserId() + " doesn't exist"); // todo
    }

    @Override
    public RunPlanModel getById(Long id) {
        return runPlanRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunPlanModel> getAll() {
        return runPlanRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runPlanRepository.existsById(id)) {
            throw new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist");
        }
        runPlanRepository.deleteById(id);
    }

    @Override
    public RunPlanModel update(RunPlanModel entity) {
        existHandlerRegistry.handleRequest(ExistEnum.USER, entity.getUserId());
        if (!runPlanRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunPlan with id: " + entity.getId() + " doesn't exist");
        }
        return runPlanRepository.save(entity);
    }

    public RunPlanModel createPlan(List<RunTraining> runTrainings, RunPlanRequest runPlanRequest) {
        existHandlerRegistry.handleRequest(ExistEnum.USER, runPlanRequest.getUser_id());
        RunPlanModel runPlanModel = new RunPlanModel();
        runPlanModel.setDayOfTheWeek(runPlanRequest.getTraining_days().length);
        runPlanModel.setStartingWeeklyVolume(runPlanRequest.getKilometers_per_week());
        runPlanModel.setFinalDate(runPlanRequest.getGoal_date());
        runPlanModel.setUserId(runPlanRequest.getUser_id());
        List<TrainingModel> trainingModels = fillAndSaveTraining(runTrainings, runPlanModel);
        runPlanModel.setTrainingModels(trainingModels);
        runPlanRepository.save(runPlanModel);
        return runPlanModel;
    }

    private List<TrainingModel> fillAndSaveTraining(List<RunTraining> runTrainings, RunPlanModel runPlanModel) {
        List<TrainingModel> trainingModels = new ArrayList<>();

        for (RunTraining runTraining : runTrainings) {
            TrainingModel trainingModel = new TrainingModel();
            trainingModel.setKilometers(runTraining.getTotalDistanceKilometers());
            trainingModel.setWarmUp(runTraining.getWarmUpKilometers());
            trainingModel.setHitch(runTraining.getHitchKilometers());
            trainingModel.setStage(stageRepository.findByStageEnum(runTraining.getStageEnum()));
            trainingModel.setRunType(runTypeRepository.findByTypeName(runTraining.getTrainingType()));
            trainingModel.setRunPlan(runPlanModel);
            trainingModels.add(trainingModel);
            if (runTraining.getIntervals() != null) {
                trainingModel.setIntervalModelList(fillingDatabaseIntervals(runTraining.getIntervals(), trainingModel));
            }
        }
        return trainingModels;
    }

    private List<IntervalModel> fillingDatabaseIntervals(Interval[] intervals, TrainingModel trainingModel) {
        List<IntervalModel> intervalModels = new ArrayList<>();

        for (Interval interval : intervals) {
            IntervalModel intervalModel = new IntervalModel();
            intervalModel.setRunMetres(interval.getRun_metres());
            intervalModel.setRunPace(interval.getRun_pace());
            intervalModel.setIntervalRestType(interval.getIntervalRestType());
            intervalModel.setRestMetres(interval.getRest_metres());
            intervalModel.setRestPace(interval.getRest_pace());
            intervalModel.setTraining(trainingModel);
            intervalModel.setTimeBreak(interval.getTimeBreak());
            intervalModel.setTimeRunIntervals(interval.getTimeRunIntervals());

            intervalModels.add(intervalModel);
        }
        return intervalModels;
    }
}
