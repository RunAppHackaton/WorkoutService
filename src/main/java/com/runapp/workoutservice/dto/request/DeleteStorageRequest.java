package com.runapp.workoutservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteStorageRequest {

    private String file_uri;
    private String directory;
}
