package com.runapp.workoutservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private int caloriesBurned;
    private String notes;
    private String photosUrl;
    private RouteModel route;
    private int shoesId;
    private String userId;
    private TrainingModel training;
    private String weatherConditions;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Duration pace;
}
