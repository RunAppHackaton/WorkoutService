package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VdotWorkoutServiceImpl implements GenericService<VdotWorkoutModel> {

    private final VdotWorkoutRepository vdotWorkoutRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(VdotWorkoutServiceImpl.class);
    @Autowired
    public VdotWorkoutServiceImpl(VdotWorkoutRepository vdotWorkoutRepository) {
        this.vdotWorkoutRepository = vdotWorkoutRepository;
    }

    @Override
    public VdotWorkoutModel add(VdotWorkoutModel entity) {
        LOGGER.info("VdotWorkout add: {}", entity);
        return vdotWorkoutRepository.save(entity);
    }

    @Override
    public VdotWorkoutModel getById(Long vdot) {
        LOGGER.info("VdotWorkout get by id: %{}", vdot);
        return vdotWorkoutRepository.findById(vdot).orElseThrow(() -> new NoEntityFoundException("VDOT Workout with id: " + vdot + " doesn't exist"));
    }

    @Override
    public List<VdotWorkoutModel> getAll() {
        LOGGER.info("VdotWorkout get all");
        return vdotWorkoutRepository.findAll();
    }

    @Override
    public void deleteById(Long vdot) {
        LOGGER.info("VdotWorkout delete by id: {}", vdot);
        if (!vdotWorkoutRepository.existsById(vdot)) {
            throw new NoEntityFoundException("VDOT Workout with id: " + vdot + " doesn't exist");
        }
        vdotWorkoutRepository.deleteById(vdot);
    }

    @Override
    public VdotWorkoutModel update(VdotWorkoutModel entity) {
        LOGGER.info("VdotWorkout update: {}", entity);
        if (!vdotWorkoutRepository.existsById(entity.getVdot())) {
            throw new NoEntityFoundException("VDOT Workout with id: " + entity.getVdot() + " doesn't exist");
        }
        return vdotWorkoutRepository.save(entity);
    }
}
