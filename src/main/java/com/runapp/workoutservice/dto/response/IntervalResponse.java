package com.runapp.workoutservice.dto.response;

import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntervalResponse {
    private long id;
    private int runMetres;
    private String runPace;
    private IntervalRestTypeEnum intervalRestType;
    private int restMetres;
    private String restPace;
    private String timeBreak;
    private String timeRunIntervals;
}
