package com.runapp.workoutservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
    private LocalDateTime createDate;
    private String userImageUrl;
}
