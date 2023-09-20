package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.TrainingTypeEnum;

public class EasyRun extends RunTraining {
    public EasyRun(int totalDistanceKilometers, String totalPace) {
        super(0, 0, totalDistanceKilometers, totalPace, TrainingTypeEnum.EASY_RUN, null);
    }
}
