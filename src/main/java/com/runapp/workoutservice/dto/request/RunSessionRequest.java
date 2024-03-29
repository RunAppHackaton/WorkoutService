package com.runapp.workoutservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionRequest {

    @Positive(message = "The 'distance' should be a positive number.")
    private BigDecimal distance_km;

    @NotNull(message = "The 'time' field is required.")
    private Duration duration_time;

    @Positive(message = "The 'caloriesBurned' should be a positive number.")
    private int caloriesBurned;

    @Size(max = 1000, message = "The 'notes' field cannot exceed 1000 characters.")
    private String notes;

    @Positive(message = "The 'routeId' should be a positive number.")
    private int routeId;

    @Positive(message = "The 'shoesId' should be a positive number.")
    private int shoesId;

    private String userId;

    private List<RoutePointRequest> route_points;

    private int training_id_from_run_plan;

    private String weatherConditions;

    private Duration pace;
}
