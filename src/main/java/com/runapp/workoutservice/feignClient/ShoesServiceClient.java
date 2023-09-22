package com.runapp.workoutservice.feignClient;

import com.runapp.workoutservice.dto.response.ShoesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shoes-service")
public interface ShoesServiceClient {

    @GetMapping("/shoes/{id}")
    ResponseEntity<ShoesResponse> getShoesById(@PathVariable Long id);
}
