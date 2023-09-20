package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.TrainingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class RunTraining {
    private int warmUpKilometers;
    private int hitchKilometers;
    private int totalDistanceKilometers;
    private String totalPace;
    private TrainingTypeEnum trainingType;
    private Interval[] intervals;
}
