package com.runapp.workoutservice.dtoMapper;

import brave.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.response.IntervalResponse;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.dto.response.TrainingResponse;
import com.runapp.workoutservice.model.IntervalModel;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.model.TrainingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RunPlanDtoMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public RunPlanDtoMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RunPlanLongResponse toLongDto(RunPlanModel model) {
        RunPlanLongResponse runPlanLongResponse = new RunPlanLongResponse();
        runPlanLongResponse.setId(model.getId());
        runPlanLongResponse.setDayOfTheWeek(model.getDayOfTheWeek());
        runPlanLongResponse.setStartingWeeklyVolume(model.getStartingWeeklyVolume());
        runPlanLongResponse.setFinalDate(model.getFinalDate());
        runPlanLongResponse.setUserId(model.getUserId());
        runPlanLongResponse.setTrainings(toListTrainingResponse(model.getTrainingModels()));
        return runPlanLongResponse;
    }

    public List<RunPlanLongResponse> toLongDto(List<RunPlanModel> runPlanModels) {
        List<RunPlanLongResponse> runPlanLongResponses = new ArrayList<>();
        for (RunPlanModel runPlanModel : runPlanModels) {
            runPlanLongResponses.add(toLongDto(runPlanModel));
        }
        return runPlanLongResponses;
    }

    public List<RunPlanShortResponse> toShortDto(List<RunPlanModel> runPlanModels) {
        List<RunPlanShortResponse> runPlanLongResponses = new ArrayList<>();
        for (RunPlanModel runPlanModel : runPlanModels) {
            runPlanLongResponses.add(objectMapper.convertValue(runPlanModel, RunPlanShortResponse.class));
        }
        return runPlanLongResponses;
    }

    private List<TrainingResponse> toListTrainingResponse(List<TrainingModel> trainingModels) {
        return trainingModels.stream()
                .map(trainingModel -> {
                    return TrainingResponse.builder()
                            .id(trainingModel.getId())
                            .kilometers(trainingModel.getKilometers())
                            .warmUp(trainingModel.getWarmUp())
                            .hitch(trainingModel.getHitch())
                            .stage(trainingModel.getStage().getStageEnum())
                            .run_type_id(trainingModel.getRunType().getId())
                            .typeName(trainingModel.getRunType().getTypeName())
                            .intervals(getListIntervalsResponse(trainingModel.getIntervalModelList()))
                            .build();
                })
                .collect(Collectors.toList());
    }

    private List<IntervalResponse> getListIntervalsResponse(List<IntervalModel> models) {
        if (models == null) return Collections.emptyList();
        else {
            return models.stream()
                    .map(this::mapToIntervalResponse)
                    .collect(Collectors.toList());
        }
    }

    private IntervalResponse mapToIntervalResponse(IntervalModel intervalModel) {
        IntervalResponse intervalResponse = new IntervalResponse();
        intervalResponse.setId(intervalModel.getId());
        intervalResponse.setRunMetres(intervalModel.getRunMetres());
        intervalResponse.setRunPace(intervalModel.getRunPace());
        intervalResponse.setIntervalRestType(intervalModel.getIntervalRestType());
        intervalResponse.setRestMetres(intervalModel.getRestMetres());
        intervalResponse.setRestPace(intervalModel.getRestPace());
        intervalResponse.setTimeBreak(intervalModel.getTimeBreak());
        intervalResponse.setTimeRunIntervals(intervalModel.getTimeRunIntervals());
        intervalResponse.setTimeBreak(intervalModel.getTimeBreak());
        intervalResponse.setTimeRunIntervals(intervalModel.getTimeRunIntervals());
        return intervalResponse;
    }
}
