package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.enums.StageEnum;
import com.runapp.workoutservice.utill.enums.TrainingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class RunTraining {
    private int warmUpKilometers;
    private int hitchKilometers;
    private int totalDistanceKilometers;
    private String totalPace;
    private TrainingTypeEnum trainingType;
    private Interval[] intervals;
    private LocalDate date;
    private StageEnum stageEnum;
}
