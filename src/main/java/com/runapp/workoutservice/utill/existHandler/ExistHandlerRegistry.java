package com.runapp.workoutservice.utill.existHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExistHandlerRegistry {
    private final Map<ExistEnum, ExistHandler> existHandlers;

    @Autowired
    public ExistHandlerRegistry(
            GuildExistHandler guildExistHandler,
            ShoesExistHandler shoesExistHandler,
            AchievementExistHandler achievementExistHandler
    ) {
        existHandlers = new HashMap<>();
        existHandlers.put(ExistEnum.GUILD, guildExistHandler);
        existHandlers.put(ExistEnum.SHOES, shoesExistHandler);
        existHandlers.put(ExistEnum.ACHIEVEMENT, achievementExistHandler);
    }

    public void handleRequest(ExistEnum existEnum, int entityId) {
        ExistHandler existHandler = existHandlers.get(existEnum);
        if (existHandler != null) {
            existHandler.handleRequest(entityId);
        } else {
            throw new IllegalArgumentException("No handler found for ExistEnum: " + existEnum);
        }
    }
}
