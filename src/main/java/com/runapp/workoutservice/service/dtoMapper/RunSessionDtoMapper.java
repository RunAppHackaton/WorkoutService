package com.runapp.workoutservice.service.dtoMapper;

import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.TrainingModel;

import java.util.ArrayList;
import java.util.List;

public class RunSessionDtoMapper {

    public static RunSessionModel toModel(RunSessionRequest request) {
        RunSessionModel model = new RunSessionModel();
        model.setDate(request.getDate());
        model.setDistance_km(request.getDistance_km());
        model.setTime(request.getTime());
        model.setPace(request.getPace().intValue());
        model.setCaloriesBurned(request.getCaloriesBurned());
        model.setWeatherConditions(request.getWeatherConditions());
        model.setNotes(request.getNotes());
        model.setAchievementId(request.getAchievementId());
        model.setShoesId(request.getShoesId());
        model.setUserId(request.getUserId());
        model.setTeamId(request.getTeamId());
        model.setRoute(request.getRoute());
        model.setPhotosUrl("DEFAULT");
        model.setTraining(new TrainingModel(request.getTraining_id()));
        return model;
    }

    public static RunSessionResponse toResponse(RunSessionModel model) {
        RunSessionResponse response = new RunSessionResponse();
        response.setId(model.getId());
        response.setDate(model.getDate());
        response.setDistance_km(model.getDistance_km());
        response.setTime(model.getTime());
        response.setPace(model.getPace());
        response.setCaloriesBurned(model.getCaloriesBurned());
        response.setWeatherConditions(model.getWeatherConditions());
        response.setNotes(model.getNotes());
        response.setPhotosUrl(model.getPhotosUrl());
        response.setTraining_id(model.getTraining().getId());
        response.setUserId(model.getUserId());
        response.setTeamId(model.getTeamId());
        response.setAchievementId(model.getAchievementId());
        response.setShoesId(model.getShoesId());
        response.setRoute(model.getRoute());
        return response;
    }

    public static List<RunSessionResponse> toResponseList(List<RunSessionModel> runSessionModels) {
        List<RunSessionResponse> runSessionResponses = new ArrayList<>();
        for (RunSessionModel runSessionModel : runSessionModels) {
            runSessionResponses.add(toResponse(runSessionModel));
        }
        return runSessionResponses;
    }
}
