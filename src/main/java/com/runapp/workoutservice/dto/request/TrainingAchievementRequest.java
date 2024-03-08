package com.runapp.workoutservice.dto.request;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class TrainingAchievementRequest {
    private LocalDate training_date;
    private int distance_km;
    private Duration training_duration;
    private Duration pace;
    private String userId;
}
