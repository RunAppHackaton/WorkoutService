package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.repository.VdotWorkoutRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    @Caching(put = {@CachePut(value = "vdot_workout", key = "#result.vdot")},
            evict = {@CacheEvict(value = "vdot_workout", allEntries = true)})
    public VdotWorkoutModel add(VdotWorkoutModel entity) {
        LOGGER.info("VdotWorkout add: {}", entity);
        return vdotWorkoutRepository.save(entity);
    }

    @Override
    @Cacheable(value = "vdot_workout", key = "#vdot")
    public VdotWorkoutModel getById(Long vdot) {
        LOGGER.info("VdotWorkout get by id: %{}", vdot);
        return vdotWorkoutRepository.findById(vdot).orElseThrow(() -> new NoEntityFoundException("VDOT Workout with id: " + vdot + " doesn't exist"));
    }

    @Override
    @Cacheable(value = "vdot_workout")
    public List<VdotWorkoutModel> getAll() {
        List<VdotWorkoutModel> vdotGradeModels = vdotWorkoutRepository.findAll();
        if (vdotGradeModels.isEmpty()) {
            LOGGER.warn("No VdotWorkout records found in the database");
            throw new NoEntityFoundException("VdotWorkout records doesn't exist");
        }
        LOGGER.info("VdotWorkout get all");
        return vdotGradeModels;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "vdot_workout", allEntries = true),
            @CacheEvict(value = "vdot_workout", key = "#vdot")
    })
    public void deleteById(Long vdot) {
        LOGGER.info("VdotWorkout delete by id: {}", vdot);
        if (!vdotWorkoutRepository.existsById(vdot)) {
            throw new NoEntityFoundException("VDOT Workout with id: " + vdot + " doesn't exist");
        }
        vdotWorkoutRepository.deleteById(vdot);
    }

    @Override
    @Caching(put = {@CachePut(value = "vdot_workout", key = "#result.vdot")},
            evict = {@CacheEvict(value = "vdot_workout", allEntries = true)})
    public VdotWorkoutModel update(VdotWorkoutModel entity) {
        LOGGER.info("VdotWorkout update: {}", entity);
        if (!vdotWorkoutRepository.existsById(entity.getVdot())) {
            throw new NoEntityFoundException("VDOT Workout with id: " + entity.getVdot() + " doesn't exist");
        }
        return vdotWorkoutRepository.save(entity);
    }
}
