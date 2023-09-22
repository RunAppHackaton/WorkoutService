package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.StageEnum;
import com.runapp.workoutservice.utill.TrainingTypeEnum;

import java.time.LocalDate;

public class LongRun extends RunTraining {

    public LongRun(int totalDistanceKilometers, String totalPace, LocalDate date, StageEnum stage) {
        super(0, 0, totalDistanceKilometers, totalPace, TrainingTypeEnum.LONG_RUN, null, date, stage);
    }
}
