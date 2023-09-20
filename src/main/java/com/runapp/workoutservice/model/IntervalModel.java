package com.runapp.workoutservice.model;

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
    private int id;

    @Column(name = "interval")
    private int interval;

    @Column(name = "time_for_a_break")
    private int timeForABreak;

    @ManyToOne
    @JoinColumn(name = "Training_id", referencedColumnName = "id")
    private TrainingModel training;
}
