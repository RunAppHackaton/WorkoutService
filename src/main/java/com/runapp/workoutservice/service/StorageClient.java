package com.runapp.workoutservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface StorageClient<R> {
    ResponseEntity<Object> deleteImage(R deleteRequest);

    ResponseEntity<Object> uploadImage(MultipartFile file, Long id);
}
