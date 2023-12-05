package com.runapp.workoutservice.utill.existHandler;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.ShoesServiceClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoesExistHandler implements ExistHandler {
    private final ShoesServiceClient shoesServiceClient;

    @Override
    public boolean handleRequest(int entityId) {
        try {
            shoesServiceClient.getShoesById((long) entityId);
        } catch (FeignException.NotFound e) {
            throw new NoEntityFoundException("Shoes with id: " + entityId + " doesn't exist");
        }
        return true;
    }
}
