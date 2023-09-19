package com.runapp.workoutservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VDOT_Grade")
public class VdotGradeModel {

    @Id
    @Column(name = "vdot")
    private Long vdot;

    @Column(name = "easy_1500m")
    private String easy1500m;

    @Column(name = "easy_mile")
    private String easyMile;

    @Column(name = "easy_3000m")
    private String easy3000m;

    @Column(name = "easy_2mile")
    private String easy2Mile;

    @Column(name = "easy_5000m")
    private String easy5000m;

    @Column(name = "easy_10000m")
    private String easy10000m;

    @Column(name = "easy_15000m")
    private String easy15000m;

    @Column(name = "half_marathon")
    private String halfMarathon;

    @Column(name = "marathon")
    private String marathon;
}
