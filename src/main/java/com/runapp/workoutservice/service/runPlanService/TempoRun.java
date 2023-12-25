package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;

import java.time.LocalDate;

public class TempoRun extends RunTraining {
    public TempoRun(int totalDistanceKilometers, String totalPace, LocalDate date, StageEnum stage) {
        super(0, 0, totalDistanceKilometers, totalPace, TrainingTypeEnum.TEMPO_RUN, null, date, stage);
    }
}
