package com.runapp.workoutservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
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
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "distance")
    private int distance;

    @Column(name = "time")
    private Duration time;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private RouteModel route;

    @ManyToOne
    @JoinColumn(name = "Training_id", referencedColumnName = "id")
    private TrainingModel training;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "shoes_id")
    private int shoesId;
}
