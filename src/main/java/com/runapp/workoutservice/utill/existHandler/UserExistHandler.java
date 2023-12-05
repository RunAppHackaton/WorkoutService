package com.runapp.workoutservice.utill.existHandler;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.ProfileServiceClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserExistHandler implements ExistHandler {

    private final ProfileServiceClient profileServiceClient;

    @Override
    public boolean handleRequest(int entityId) {
        try {
            profileServiceClient.getUserById(entityId);
        } catch (FeignException.NotFound e) {
            throw new NoEntityFoundException("User with id: " + entityId + " doesn't exist");
        }
        return true;
    }
}
