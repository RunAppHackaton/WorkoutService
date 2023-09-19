package com.runapp.workoutservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AchievementResponse {

    private int id;

    private String name;

    private int story_id;

    private String description;

    private String achievementImageUrl;

    private RarityResponse rarityModel;
}
