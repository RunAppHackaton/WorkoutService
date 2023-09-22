package com.runapp.workoutservice.service.dtoMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dto.response.RunPlanLongResponse;
import com.runapp.workoutservice.dto.response.RunPlanShortResponse;
import com.runapp.workoutservice.model.RunPlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RunPlanDtoMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public RunPlanDtoMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RunPlanShortResponse toShortDto(RunPlanModel model) {
        return objectMapper.convertValue(model, RunPlanShortResponse.class);
    }

    public RunPlanLongResponse toLongDto(RunPlanModel model) {
        return objectMapper.convertValue(model, RunPlanLongResponse.class);
    }

    public List<RunPlanLongResponse> toLongDto(List<RunPlanModel> runPlanModels) {
        List<RunPlanLongResponse> runPlanLongResponses = new ArrayList<>();
        for (RunPlanModel runPlanModel : runPlanModels) {
            runPlanLongResponses.add(objectMapper.convertValue(runPlanModel, RunPlanLongResponse.class));
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
}
