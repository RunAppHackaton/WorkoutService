package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.dto.request.DeleteStorageRequest;
import com.runapp.workoutservice.dto.request.RunSessionImageDeleteRequest;
import com.runapp.workoutservice.dto.response.DeleteResponse;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.*;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.repository.RunSessionRepository;
import com.runapp.workoutservice.service.RunSessionService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RunSessionServiceImpl implements RunSessionService {

    private final RunSessionRepository runSessionRepository;
    private final StorageServiceClient storageServiceClient;
    private final AchievementServiceClient achievementServiceClient;
    private final ShoesServiceClient shoesServiceClient;
    private final ProfileServiceClient profileServiceClient;
    private final GuildServiceClient guildServiceClient;

    @Value("${storage-directory}")
    private String storageDirectory;

    @Autowired
    public RunSessionServiceImpl(RunSessionRepository runSessionRepository, StorageServiceClient storageServiceClient, AchievementServiceClient achievementServiceClient, ShoesServiceClient shoesServiceClient, ProfileServiceClient profileServiceClient, GuildServiceClient guildServiceClient) {
        this.runSessionRepository = runSessionRepository;
        this.storageServiceClient = storageServiceClient;
        this.achievementServiceClient = achievementServiceClient;
        this.shoesServiceClient = shoesServiceClient;
        this.profileServiceClient = profileServiceClient;
        this.guildServiceClient = guildServiceClient;
    }

    @Override
    public RunSessionModel add(RunSessionModel entity) {
        try {
            profileServiceClient.getUserById(entity.getUserId()).getBody();
            guildServiceClient.getTeamById(entity.getTeamId());
            shoesServiceClient.getShoesById(entity.getShoesId());
            //todo обдумать момент с ачивками
//            achievementServiceClient.getAchievementsByStoryId(entity.);
        } catch (FeignException e) {
            throw new NoEntityFoundException("Exception");
        }
        return runSessionRepository.save(entity);
    }

    @Override
    public RunSessionModel getById(Long id) {
        return runSessionRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("RunSession with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunSessionModel> getAll() {
        return runSessionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!runSessionRepository.existsById(id)) {
            throw new NoEntityFoundException("RunSession with id: " + id + " doesn't exist");
        }
        runSessionRepository.deleteById(id);
    }

    @Override
    public RunSessionModel update(RunSessionModel entity) {
        if (!runSessionRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunSession with id: " + entity.getId() + " doesn't exist");
        }
        try {
            profileServiceClient.getUserById(entity.getUserId()).getBody();
            guildServiceClient.getTeamById(entity.getTeamId());
            shoesServiceClient.getShoesById(entity.getShoesId());
            //todo обдумать момент с ачивками
//            achievementServiceClient.getAchievementsByStoryId(entity.);
        } catch (FeignException e) {
            throw new NoEntityFoundException("Exception");
        }
        return runSessionRepository.save(entity);
    }

    @Override
    public ResponseEntity<Object> deleteImage(RunSessionImageDeleteRequest deleteRequest) {
        RunSessionModel runSessionModel = runSessionRepository.findById(deleteRequest.getRun_type_id()).
                orElseThrow(() -> new NoEntityFoundException("RunType with id: " + deleteRequest.getRun_type_id() + " doesn't exist"));
        runSessionModel.setPhotosUrl("DEFAULT");
        runSessionRepository.save(runSessionModel);
        try {
            storageServiceClient.deleteFile(new DeleteStorageRequest(deleteRequest.getFile_uri(), storageDirectory));
            return ResponseEntity.ok().build();
        } catch (FeignException.InternalServerError e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DeleteResponse("the image does not exist or the data was transferred incorrectly"));
        }
    }

    @Override
    public ResponseEntity<Object> uploadImage(MultipartFile file, Long id) {
        RunSessionModel runSessionModel = runSessionRepository.findById(id).
                orElseThrow(() -> new NoEntityFoundException("RunType with id: " + id + " doesn't exist"));
        runSessionModel.setPhotosUrl(storageServiceClient.uploadFile(file, storageDirectory).getFile_uri());
        runSessionRepository.save(runSessionModel);
        return ResponseEntity.ok().body(runSessionModel);
    }
}
