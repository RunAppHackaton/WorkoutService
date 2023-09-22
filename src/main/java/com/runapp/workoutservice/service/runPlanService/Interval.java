package com.runapp.workoutservice.service.runPlanService;

import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interval {
    private int run_metres;
    private String run_pace;
    private IntervalRestTypeEnum intervalRestType;
    private int rest_metres;
    private String rest_pace;
    private String timeBreak;
    private String timeRunIntervals;
}
