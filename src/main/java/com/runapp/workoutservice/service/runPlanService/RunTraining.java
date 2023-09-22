package com.runapp.workoutservice.service.runPlanService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.runapp.workoutservice.utill.StageEnum;
import com.runapp.workoutservice.utill.TrainingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
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
