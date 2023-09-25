package com.runapp.workoutservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.TrainingModel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionRequest {

    @NotNull(message = "The 'date' field is required.")
    @Past(message = "The 'date' should be in the past.")
    private LocalDateTime date;

    @Positive(message = "The 'distance' should be a positive number.")
    private BigDecimal distance_km;

    @NotNull(message = "The 'time' field is required.")
    private Duration time;

    @Positive(message = "The 'pace' should be a positive number.")
    private BigDecimal pace;

    @Positive(message = "The 'caloriesBurned' should be a positive number.")
    private int caloriesBurned;

    private String weatherConditions;

    @Size(max = 1000, message = "The 'notes' field cannot exceed 1000 characters.")
    private String notes;

    @Positive(message = "The 'achievementId' should be a positive number.")
    private int achievementId;

    @Positive(message = "The 'shoesId' should be a positive number.")
    private int shoesId;

    @Positive(message = "The 'userId' should be a positive number.")
    private int userId;

    @Positive(message = "The 'teamId' should be a positive number.")
    private int teamId;

    private RouteModel route;

    private long training_id;
}
