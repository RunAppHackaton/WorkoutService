package com.runapp.workoutservice.dto.request;

import com.runapp.workoutservice.utill.DistanceTypeEnum;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VdotGradeRequest {

    private DistanceTypeEnum distance;

    @Pattern(regexp = "^([0-9]{1,2}):([0-5]\\d):([0-5]\\d)$", message = "Invalid time format(HH:MM:SS)")
    private String time;
}
