package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.dto.request.DeleteStorageRequest;
import com.runapp.workoutservice.dto.request.RunTypeImageDeleteRequest;
import com.runapp.workoutservice.dto.response.DeleteResponse;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.StorageServiceClient;
import com.runapp.workoutservice.model.RunTypeModel;
import com.runapp.workoutservice.repository.RunTypeRepository;
import com.runapp.workoutservice.service.RunTypeService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RunTypeServiceImpl implements RunTypeService {

    private final StorageServiceClient storageServiceClient;
    private final RunTypeRepository runTypeRepository;

    @Value("${storage-directory}")
    private String storageDirectory;

    @Autowired
    public RunTypeServiceImpl(StorageServiceClient storageServiceClient, RunTypeRepository runTypeRepository) {
        this.storageServiceClient = storageServiceClient;
        this.runTypeRepository = runTypeRepository;
    }

    @Override
    public ResponseEntity<Object> deleteImage(RunTypeImageDeleteRequest deleteRequest) {
        RunTypeModel runTypeModel = runTypeRepository.findById(deleteRequest.getRun_type_id()).
                orElseThrow(() -> new NoEntityFoundException("RunType with id: " + deleteRequest.getRun_type_id() + " doesn't exist"));
        runTypeModel.setRuntypeImageUrl("DEFAULT");
        runTypeRepository.save(runTypeModel);
        try {
            storageServiceClient.deleteFile(new DeleteStorageRequest(deleteRequest.getFile_uri(), storageDirectory));
            return ResponseEntity.ok().build();
        } catch (FeignException.InternalServerError e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DeleteResponse("the image does not exist or the data was transferred incorrectly"));
        }
    }

    @Override
    public ResponseEntity<Object> uploadImage(MultipartFile file, Long id) {
        RunTypeModel runTypeModel = runTypeRepository.findById(id).
                orElseThrow(() -> new NoEntityFoundException("RunType with id: " + id + " doesn't exist"));
        runTypeModel.setRuntypeImageUrl(storageServiceClient.uploadFile(file, storageDirectory).getFile_uri());
        runTypeRepository.save(runTypeModel);
        return ResponseEntity.ok().body(runTypeModel);
    }
}
