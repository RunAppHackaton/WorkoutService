package com.runapp.workoutservice.repository;

import com.runapp.workoutservice.model.StageModel;
import com.runapp.workoutservice.utill.enums.StageEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<StageModel, Long> {
    StageModel findByStageEnum(StageEnum stageEnum);
}
