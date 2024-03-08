package com.runapp.workoutservice.dto.request;

import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import com.runapp.workoutservice.utill.enums.RunPlanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunPlanRequest {
    private String user_id;
    private RunPlanEnum runPlanEnum;
    private LocalDate goal_date;
    private String target_time;
    private DistanceTypeEnum type_were_you_running;
    private String time_at_which_you_ran;
    private int kilometers_per_week;
    private int number_of_workouts_per_week;
    private DayOfWeek[] training_days;
}
