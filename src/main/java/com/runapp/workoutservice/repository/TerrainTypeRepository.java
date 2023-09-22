package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.TerrainTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainTypeRepository extends JpaRepository<TerrainTypeModel, Long> {
}
