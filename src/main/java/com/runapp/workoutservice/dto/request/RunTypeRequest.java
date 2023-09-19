package com.runapp.workoutservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunTypeRequest {
    @NotBlank(message = "The 'type_name' field is required.")
    @Size(max = 255, message = "The 'type_name' field cannot exceed 255 characters.")
    private String type_name;

    @NotBlank(message = "The 'description' field is required.")
    private String description;

    @Min(value = 0, message = "can't store value less than 0")
    private int intervals;
}
