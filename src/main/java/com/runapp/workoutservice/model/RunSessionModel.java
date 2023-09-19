package com.runapp.workoutservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "distance")
    private BigDecimal distance;

    @Column(name = "time")
    private Duration time;

    @Column(name = "pace")
    private BigDecimal pace;

    @Column(name = "calories_burned")
    private int caloriesBurned;

    @Column(name = "weather_conditions")
    private String weatherConditions;

    @Column(name = "notes")
    private String notes;

    @Column(name = "photos_url")
    private String photosUrl;

    @OneToOne()
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private RouteModel route;

    @ManyToOne
    @JoinColumn(name = "runtype_id")
    private RunTypeModel runType;

    @Column(name = "achievement_id")
    private int achievementId;

    @Column(name = "shoes_id")
    private int shoesId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "team_id")
    private int teamId;
}
