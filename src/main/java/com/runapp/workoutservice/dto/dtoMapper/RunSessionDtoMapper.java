package com.runapp.workoutservice.dto.dtoMapper;

import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.RoutePointModel;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.TrainingModel;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public class RunSessionDtoMapper implements DtoMapper<RunSessionModel, RunSessionRequest, RunSessionResponse> {

    @Override
    public RunSessionResponse toResponse(RunSessionModel model) {
        return RunSessionResponse.builder()
                .id(model.getId())
                .date(model.getDate())
                .distance(model.getDistance())
                .time(model.getTime())
                .pace(model.getPace())
                .caloriesBurned(model.getCaloriesBurned())
                .weatherConditions(model.getWeatherConditions())
                .notes(model.getNotes())
                .photosUrl(model.getPhotosUrl())
                .route(model.getRoute())
                .training(model.getTraining())
                .userId(model.getUserId())
                .teamId(model.getTeamId())
                .achievementId(model.getAchievementId())
                .shoesId(model.getShoesId())
                .build();
    }

    @Override
    public RunSessionModel toModel(RunSessionRequest request) {
        RunSessionModel model = new RunSessionModel();
        model.setDistance(request.getDistance().intValue());
        model.setTime(Time.valueOf(request.getTime().toString()));
        model.setPace(request.getPace().intValue());
        model.setCaloriesBurned(request.getCaloriesBurned());
        model.setWeatherConditions(request.getWeatherConditions());
        model.setNotes(request.getNotes());
        model.setUserId(request.getUserId());
        model.setTeamId(request.getTeamId());
        model.setAchievementId(request.getAchievementId());
        model.setShoesId(request.getShoesId());
        model.setRoute(createRouteEntityByListPoints(request.getRoute_points()));
        model.setTraining(getTrainingEntityById(request.getTraining_id()));
        return model;
    }

    private RouteModel createRouteEntityByListPoints(List<RoutePointModel> routePointList) {
        RouteModel routeModel = new RouteModel();
        routeModel.setRoutePoints(routePointList);
        return routeModel;
    }

    private TrainingModel getTrainingEntityById(int id) {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setId(id);
        return trainingModel;
    }
}
