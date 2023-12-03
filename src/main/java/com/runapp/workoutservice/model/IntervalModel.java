package com.runapp.workoutservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.workoutservice.utill.IntervalRestTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Intervals")
public class IntervalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "run_metres")
    private int runMetres;

    @Column(name = "run_pace")
    private String runPace;

    @Column(name = "rest_type")
    @Enumerated(EnumType.STRING)
    private IntervalRestTypeEnum intervalRestType;

    @Column(name = "rest_metres")
    private int restMetres;

    @Column(name = "rest_pace")
    private String restPace;

    @Column(name = "time_break")
    private String timeBreak;

    @Column(name = "time_run_intervals")
    private String timeRunIntervals;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private TrainingModel training;
}
