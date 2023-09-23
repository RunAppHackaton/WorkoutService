package com.runapp.workoutservice.service.dtoMapper;

import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RunSessionModel;

public class RunSessionDtoMapper implements DtoMapper<RunSessionModel, RunSessionRequest, RunSessionResponse> {
    @Override
    public RunSessionModel toModel(RunSessionRequest dto) {
        return null;
    }

    @Override
    public RunSessionResponse toDto(RunSessionModel model) {
        return null;
    }
}
