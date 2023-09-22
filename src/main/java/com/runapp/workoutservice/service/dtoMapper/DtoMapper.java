package com.runapp.workoutservice.service.dtoMapper;

public interface DtoMapper<M, R, S> {
    M toModel(R dto);

    S toDto(M model);
}
