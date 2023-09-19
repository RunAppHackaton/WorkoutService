package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.IntervalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsRepository extends JpaRepository<IntervalsModel, Long> {
}
