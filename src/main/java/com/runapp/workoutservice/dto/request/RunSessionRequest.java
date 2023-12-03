package com.runapp.workoutservice.dto.request;

import com.runapp.workoutservice.model.RoutePointModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionRequest {

    @Positive(message = "The 'distance' should be a positive number.")
    private BigDecimal distance;

    @NotNull(message = "The 'time' field is required.")
    private Duration time;

    @Positive(message = "The 'pace' should be a positive number.")
    private BigDecimal pace;

    @Positive(message = "The 'caloriesBurned' should be a positive number.")
    private int caloriesBurned;

    @Size(max = 1000, message = "The 'notes' field cannot exceed 1000 characters.")
    private String notes;

    @Positive(message = "The 'routeId' should be a positive number.")
    private int routeId;

    @Positive(message = "The 'achievementId' should be a positive number.")
    private int achievementId;

    @Positive(message = "The 'shoesId' should be a positive number.")
    private int shoesId;

    @Positive(message = "The 'userId' should be a positive number.")
    private int userId;

    @Positive(message = "The 'teamId' should be a positive number.")
    private int teamId;

    private List<RoutePointModel> route_points;

    private int training_id;

    private String weatherConditions;
}
