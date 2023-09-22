package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.RunSessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunSessionRepository extends JpaRepository<RunSessionModel, Long> {
}
