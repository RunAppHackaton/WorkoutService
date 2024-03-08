package com.runapp.workoutservice.dtoMapper;

public interface DtoMapper<Model, Request, Response> {
    Response toResponse(Model model);

    Model toModel(Request request);
}
