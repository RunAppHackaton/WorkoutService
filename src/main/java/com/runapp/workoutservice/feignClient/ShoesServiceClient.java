package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.ShoesResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "shoes-service")
public interface ShoesServiceClient {

    @GetMapping("/shoes/{id}")
    ResponseEntity<ShoesResponse> getShoesById(@PathVariable Long id);

    @PutMapping("/shoes/update-mileage/{id}/{additionalKilometers}")
    ResponseEntity<Object> updateMileage(@PathVariable Long id, @PathVariable int additionalKilometers);
}
