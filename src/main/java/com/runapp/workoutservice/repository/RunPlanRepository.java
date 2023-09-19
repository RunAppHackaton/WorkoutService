package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.RunPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunPlanRepository extends JpaRepository<RunPlanModel, Long> {
}
