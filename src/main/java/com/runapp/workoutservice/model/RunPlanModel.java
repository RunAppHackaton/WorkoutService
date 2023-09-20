package com.runapp.workoutservice.model;

import com.runapp.workoutservice.utill.DayOfTheWeeksEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RunPlan")
public class RunPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "day_of_the_week")
    private int dayOfTheWeek;

    @Column(name = "distance")
    private int distance;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "pace")
    private double pace;

    @Column(name = "note")
    private int note;

    @Column(name = "user_id")
    private int userId;
}
