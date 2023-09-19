package com.runapp.workoutservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VDOT_Workout")
public class VdotWorkoutModel {

    @Id
    @Column(name = "VDOT")
    private Long vdot;

    @Column(name = "easy_mi")
    private String easyMi;

    @Column(name = "easy_km")
    private String easyKm;

    @Column(name = "marathon_mi")
    private String marathonMi;

    @Column(name = "marathon_km")
    private String marathonKm;

    @Column(name = "threshold_400m")
    private String threshold_400m;

    @Column(name = "threshold_1000m")
    private String threshold_1000m;

    @Column(name = "threshold_mi")
    private String threshold_mi;

    @Column(name = "interval_400m")
    private String interval_400m;

    @Column(name = "interval_1000m")
    private String interval_1000m;

    @Column(name = "interval_1200m")
    private String interval_1200m;

    @Column(name = "interval_mi")
    private String interval_mi;

    @Column(name = "repetition_200m")
    private String repetition_200m;

    @Column(name = "repetition_400m")
    private String repetition_400m;

    @Column(name = "repetition_800m")
    private String repetition_800m;
}
