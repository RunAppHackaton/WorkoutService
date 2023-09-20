package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.TrainingTypeEnum;

public class TempoRun extends RunTraining {
    public TempoRun(int totalDistanceKilometers, String totalPace) {
        super(0, 0, totalDistanceKilometers, totalPace, TrainingTypeEnum.TEMPO_RUN, null);
    }
}
