package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.RunPlanModel;
import com.runapp.workoutservice.repository.RunPlanRepository;
import com.runapp.workoutservice.service.RunPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunPlanServiceImpl implements RunPlanService {

    private final RunPlanRepository runPlanRepository;

    @Autowired
    public RunPlanServiceImpl(RunPlanRepository runPlanRepository) {
        this.runPlanRepository = runPlanRepository;
    }

    @Override
    public RunPlanModel add(RunPlanModel entity) {
        return runPlanRepository.save(entity);
    }

    @Override
    public RunPlanModel getById(Long id) {
        return runPlanRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunPlanModel> getAll() {
        return runPlanRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runPlanRepository.existsById(id)) {
            throw new NoEntityFoundException("RunPlan with id: " + id + " doesn't exist");
        }
        runPlanRepository.deleteById(id);
    }

    @Override
    public RunPlanModel update(RunPlanModel entity) {
//        if (!runPlanRepository.existsById(entity.getId())) {
//            throw new NoEntityFoundException("RunPlan with id: " + entity.getId() + " doesn't exist");
//        }
//        return runPlanRepository.save(entity);
        return null;
    }
}
