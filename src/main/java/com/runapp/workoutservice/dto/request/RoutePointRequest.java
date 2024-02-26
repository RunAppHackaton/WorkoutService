package com.runapp.workoutservice.dto.request;

import com.runapp.workoutservice.model.RouteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoutePointRequest {
    private long id;
    private double latitude;
    private double longitude;
}
