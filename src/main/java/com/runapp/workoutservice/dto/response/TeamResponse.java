package com.runapp.workoutservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

    private int id;

    private String teamName;

    private String descriptionTeam;

    private LocalDateTime createDate;

    private String teamImageUrl;

    private Long ranking;

    private int storyId;

    private int maximumPlayers;

    private int adminId;

    private List<UserTeamResponse> users_in_team;
}
