package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.TrainingTypeEnum;

public class LongRun extends RunTraining {

    public LongRun(int totalDistanceKilometers, String totalPace) {
        super(0, 0, totalDistanceKilometers, totalPace, TrainingTypeEnum.LONG_RUN, null);
    }
}
