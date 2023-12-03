package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VdotWorkoutServiceImpl implements GenericService<VdotWorkoutModel> {

    private final VdotWorkoutRepository vdotWorkoutRepository;

    @Autowired
    public VdotWorkoutServiceImpl(VdotWorkoutRepository vdotWorkoutRepository) {
        this.vdotWorkoutRepository = vdotWorkoutRepository;
    }

    @Override
    public VdotWorkoutModel add(VdotWorkoutModel entity) {
        return vdotWorkoutRepository.save(entity);
    }

    @Override
    public VdotWorkoutModel getById(Long vdod) {
        return vdotWorkoutRepository.findById(vdod).orElseThrow(() -> new NoEntityFoundException("VDOT Workout with id: " + vdod + " doesn't exist"));
    }

    @Override
    public List<VdotWorkoutModel> getAll() {
        return vdotWorkoutRepository.findAll();
    }

    @Override
    public void deleteById(Long vdod) {
        if (!vdotWorkoutRepository.existsById(vdod)) {
            throw new NoEntityFoundException("VDOT Workout with id: " + vdod + " doesn't exist");
        }
        vdotWorkoutRepository.deleteById(vdod);
    }

    @Override
    public VdotWorkoutModel update(VdotWorkoutModel entity) {
        if (!vdotWorkoutRepository.existsById(entity.getVdot())) {
            throw new NoEntityFoundException("VDOT Workout with id: " + entity.getVdot() + " doesn't exist");
        }
        return vdotWorkoutRepository.save(entity);
    }
}
