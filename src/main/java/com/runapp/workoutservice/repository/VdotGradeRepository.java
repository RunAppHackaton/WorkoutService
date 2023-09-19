package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.VdotGradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VdotGradeRepository extends JpaRepository<VdotGradeModel, Long> {

//    @Query(value = "SELECT vdot, :column FROM VdotGradeModel")
//    List<VdotGradeModel> getModelsByColumn(@Param("column") String column);
}
