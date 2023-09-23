package com.runapp.workoutservice.service;

import com.runapp.workoutservice.dto.request.RunSessionImageDeleteRequest;
import com.runapp.workoutservice.model.RunSessionModel;

public interface RunSessionService extends GenericService<RunSessionModel>, StorageClient<RunSessionImageDeleteRequest> {
}
