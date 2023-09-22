package com.runapp.workoutservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoesResponse {

    private Long id;
    private String brand;
    private String model;
    private int size;
    private int mileage;
    private String condition;
    private int userId;
    private String shoes_image_url;
}
