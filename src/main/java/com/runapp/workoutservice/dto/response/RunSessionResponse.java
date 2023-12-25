package com.runapp.workoutservice.dto.response;

import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.TrainingModel;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;

@Data
@Builder
public class RunSessionResponse {
    private long id;
    private LocalDate date;
    private int distance;
    private Duration duration_time;
    private Duration pace;
    private int caloriesBurned;
    private String weatherConditions;
    private String notes;
    private String photosUrl;
    private RouteModel route;
    private TrainingModel training;
    private int userId;
    private int shoesId;
}
