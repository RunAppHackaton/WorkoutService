package com.runapp.workoutservice.utill.existHandler;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.GuildServiceClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuildExistHandler implements ExistHandler {

    private final GuildServiceClient guildServiceClient;


    @Override
    public boolean handleRequest(int entityId) {
        try {
            guildServiceClient.getTeamById(entityId);
        } catch (FeignException.NotFound e) {
            throw new NoEntityFoundException("Guild in story with id: " + entityId + " doesn't exist"); // todo
        }
        return true;
    }
}
