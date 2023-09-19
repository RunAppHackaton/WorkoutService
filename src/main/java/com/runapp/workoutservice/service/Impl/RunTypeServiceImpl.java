package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.repository.RunTypeRepository;
import com.runapp.workoutservice.service.RunTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunTypeServiceImpl implements RunTypeService {

    private final RunTypeRepository runTypeRepository;

    @Autowired
    public RunTypeServiceImpl(RunTypeRepository runTypeRepository) {
        this.runTypeRepository = runTypeRepository;
    }

    @Override
    public RunTypeModel add(RunTypeModel entity) {
        return runTypeRepository.save(entity);
    }

    @Override
    public RunTypeModel getById(Long id) {
        return runTypeRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunType with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunTypeModel> getAll() {
        return runTypeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runTypeRepository.existsById(id)) {
            throw new NoEntityFoundException("RunType with id: " + id + " doesn't exist");
        }
        runTypeRepository.deleteById(id);
    }

    @Override
    public RunTypeModel update(RunTypeModel entity) {
        if (!runTypeRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunType with id: " + entity.getId() + " doesn't exist");
        }
        return runTypeRepository.save(entity);
    }
}
