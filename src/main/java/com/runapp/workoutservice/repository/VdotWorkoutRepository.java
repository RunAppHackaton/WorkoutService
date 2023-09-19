package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.VdotWorkoutModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VdotWorkoutRepository extends JpaRepository<VdotWorkoutModel, Long> {
}
