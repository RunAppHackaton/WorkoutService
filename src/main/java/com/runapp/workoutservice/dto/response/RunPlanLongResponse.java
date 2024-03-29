package com.runapp.workoutservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunPlanLongResponse {

    private long id;
    private int dayOfTheWeek;
    private int startingWeeklyVolume;
    private LocalDate finalDate;
    private String userId;
    private List<TrainingResponse> trainings;
}
