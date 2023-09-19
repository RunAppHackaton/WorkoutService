package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.RunTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunTypeRepository extends JpaRepository<RunTypeModel, Long> {
}
