package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingModel, Long> {
}
