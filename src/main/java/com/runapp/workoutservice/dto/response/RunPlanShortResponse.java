package com.runapp.workoutservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunPlanShortResponse {
    private long id;
    private int dayOfTheWeek;
    private int startingWeeklyVolume;
    private LocalDate finalDate;
    private int userId;
}
