package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.dto.request.RunPlanRequest;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.IntervalModel;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.repository.*;
import com.runapp.workoutservice.service.serviceTemplate.RunPlanService;
import com.runapp.workoutservice.service.runPlanService.Interval;
import com.runapp.workoutservice.service.runPlanService.RunTraining;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class RunPlanServiceImpl implements RunPlanService {
    private final RunPlanRepository runPlanRepository;
    private final RunTypeRepository runTypeRepository;
    private final StageRepository stageRepository;
    private final ExistHandlerRegistry existHandlerRegistry;
    private final static Logger LOGGER = LoggerFactory.getLogger(RunPlanServiceImpl.class);

    @Override
    @Caching(put = {@CachePut(value = "run-plans", key = "#result.id")},
            evict = {@CacheEvict(value = "run-plans", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true)})
    public RunPlanModel add(RunPlanModel entity) {
        LOGGER.info("RunPlan add: {}", entity);
        return runPlanRepository.save(entity);
    }

    @Override
    @Cacheable(value = "run-plans", key = "#id")
    public RunPlanModel getById(Long id) {
        LOGGER.info("RunPlan get by id: {}", id);
        return runPlanRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist"));
    }

    @Override
    @Cacheable(value = "run-plans")
    public List<RunPlanModel> getAll() {
        List<RunPlanModel> vdotGradeModels = runPlanRepository.findAll();
        if (vdotGradeModels.isEmpty()) {
            LOGGER.warn("No RunPlan records found in the database");
            throw new NoEntityFoundException("RunPlan records don't exist");
        }
        LOGGER.info("RunPlan get all");
        return vdotGradeModels;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "run-plans", allEntries = true),
            @CacheEvict(value = "run-plans", key = "#id"),
            @CacheEvict(value = "run_plan_long_response", allEntries = true),
            @CacheEvict(value = "run_plan_long_response", allEntries = true)
    })
    public void deleteById(Long id) {
        LOGGER.info("RunPlan delete by id: {}", id);
        if (!runPlanRepository.existsById(id)) {
            throw new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist");
        }
        runPlanRepository.deleteById(id);
    }

    @Override
    @Caching(put = {@CachePut(value = "run-plans", key = "#result.id")},
            evict = {@CacheEvict(value = "run-plans", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true)
            })
    public RunPlanModel update(RunPlanModel entity) {
        LOGGER.info("RunPlan update: {}", entity);
        if (!runPlanRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunPlan with id: " + entity.getId() + " doesn't exist");
        }
        return runPlanRepository.save(entity);
    }

    @Caching(put = {@CachePut(value = "run-plans", key = "#result.id")},
            evict = {@CacheEvict(value = "run-plans", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true),
                    @CacheEvict(value = "run_plan_long_response", allEntries = true)})
    public RunPlanModel createPlan(List<RunTraining> runTrainings, RunPlanRequest runPlanRequest) {
        LOGGER.info("RunPlan createPlan: runTrainings={}, runPlanRequest={}", runTrainings, runPlanRequest);
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
        LOGGER.info("Fill and save training: runTrainings={}, runPlanModel={}", runTrainings, runPlanModel);
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
        LOGGER.info("Fill database intervals: intervals={}, trainingModel={}", Arrays.toString(intervals), trainingModel);
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
