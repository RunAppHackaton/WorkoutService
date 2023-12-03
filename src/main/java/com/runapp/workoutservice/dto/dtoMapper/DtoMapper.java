package com.runapp.workoutservice.dto.dtoMapper;

public interface DtoMapper<Model, Request, Response> {
    Response toResponse(Model model);

    Model toModel(Request request);
}
