package com.runapp.workoutservice.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VdotWorkoutResponse {

    private long vdot;
    private String easyMi;
    private String easyKm;
    private String marathonMi;
    private String marathonKm;
    private String threshold_400m;
    private String threshold_1000m;
    private String threshold_mi;
    private String interval_400m;
    private String interval_1000m;
    private String interval_1200m;
    private String interval_mi;
    private String repetition_200m;
    private String repetition_400m;
    private String repetition_800m;
}
