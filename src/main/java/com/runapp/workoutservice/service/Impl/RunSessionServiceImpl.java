package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.repository.RunSessionRepository;
import com.runapp.workoutservice.service.RunSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunSessionServiceImpl implements RunSessionService {

    private final RunSessionRepository runSessionRepository;

    @Autowired
    public RunSessionServiceImpl(RunSessionRepository runSessionRepository) {
        this.runSessionRepository = runSessionRepository;
    }

    @Override
    public RunSessionModel add(RunSessionModel entity) {
        return runSessionRepository.save(entity);
    }

    @Override
    public RunSessionModel getById(Long id) {
        return runSessionRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunSession with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunSessionModel> getAll() {
        return runSessionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runSessionRepository.existsById(id)) {
            throw new NoEntityFoundException("RunSession with id: " + id + " doesn't exist");
        }
        runSessionRepository.deleteById(id);
    }

    @Override
    public RunSessionModel update(RunSessionModel entity) {
//        if (!runSessionRepository.existsById(entity.getId())) {
//            throw new NoEntityFoundException("RunSession with id: " + entity.getId() + " doesn't exist");
//        }
//        return runSessionRepository.save(entity);
        return null;
    }
}
