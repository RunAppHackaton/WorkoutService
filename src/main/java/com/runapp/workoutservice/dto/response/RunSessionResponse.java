package com.runapp.workoutservice.dto.response;

import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.TrainingModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionResponse {

    private long id;
    private LocalDateTime date;
    private BigDecimal distance_km;
    private Duration time;
    private int pace;
    private int caloriesBurned;
    private String weatherConditions;
    private String notes;
    private String photosUrl;
    private long training_id;
    private int userId;
    private int teamId;
    private int achievementId;
    private int shoesId;
    private RouteModel route;
}
