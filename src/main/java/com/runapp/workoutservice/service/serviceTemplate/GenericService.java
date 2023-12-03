package com.runapp.workoutservice.service.serviceTemplate;

import java.util.List;

public interface GenericService<Model> {
    Model add(Model entity);

    Model getById(Long id);

    List<Model> getAll();

    void deleteById(Long id);

    Model update(Model entity);
}
