package com.runapp.workoutservice.model;

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
@Entity
@Table(name = "RunSession")
public class RunSessionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "distance")
    private int distance;

    @Column(name = "time")
    private Time time;

    @Column(name = "pace")
    private int pace;

    @Column(name = "calories_burned")
    private int caloriesBurned;

    @Column(name = "weather_conditions")
    private String weatherConditions;

    @Column(name = "notes")
    private String notes;

    @Column(name = "photos_url")
    private String photosUrl;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private RouteModel route;

    @ManyToOne
    @JoinColumn(name = "Training_id", referencedColumnName = "id")
    private TrainingModel training;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "achievement_id")
    private int achievementId;

    @Column(name = "shoes_id")
    private int shoesId;
}
