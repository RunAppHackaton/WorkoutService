package com.runapp.workoutservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Intervals")
public class IntervalsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_for_a_break")
    private Duration timeForBreak;

    @ManyToOne
    @JoinColumn(name = "runplan_id")
    private RunPlanModel runPlan;
}
