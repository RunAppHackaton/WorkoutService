package com.runapp.workoutservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    @NotBlank(message = "The 'startLocation' field is required.")
    private String startLocation;

    @NotBlank(message = "The 'endLocation' field is required.")
    private String endLocation;

    @NotNull(message = "The 'terrainTypeId' field is required.")
    private int terrainTypeId;
}
