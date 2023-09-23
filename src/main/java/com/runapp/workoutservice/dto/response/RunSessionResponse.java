package com.runapp.workoutservice.dto.response;

import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.TrainingModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionResponse {
    private long id;
    private Date date;
    private int distance;
    private Time time;
    private int pace;
    private int caloriesBurned;
    private String weatherConditions;
    private String notes;
    private String photosUrl;
    private int route;
    private int training;
    private int userId;
    private int teamId;
    private int achievementId;
    private Long shoesId;
}
