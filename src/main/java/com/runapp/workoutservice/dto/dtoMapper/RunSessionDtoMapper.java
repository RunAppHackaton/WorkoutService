package com.runapp.workoutservice.dto.dtoMapper;

import com.runapp.workoutservice.dto.request.RoutePointRequest;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.feignClient.AchievementServiceClient;
import com.runapp.workoutservice.model.RouteModel;
import com.runapp.workoutservice.model.RoutePointModel;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.TrainingModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class RunSessionDtoMapper implements DtoMapper<RunSessionModel, RunSessionRequest, RunSessionResponse> {

    private final AchievementServiceClient achievementServiceClient;

    @Override
    public RunSessionResponse toResponse(RunSessionModel model) {
        return RunSessionResponse.builder()
                .id(model.getId())
                .date(model.getDate())
                .distance(model.getDistance())
                .duration_time(model.getTime())
                .pace(model.getPace())
                .caloriesBurned(model.getCaloriesBurned())
                .weatherConditions(model.getWeatherConditions())
                .notes(model.getNotes())
                .photosUrl(model.getPhotosUrl())
                .route(model.getRoute())
                .training(model.getTraining())
                .userId(model.getUserId())
                .shoesId(model.getShoesId())
                .build();
    }

    @Override
    public RunSessionModel toModel(RunSessionRequest request) {
        RunSessionModel model = new RunSessionModel();
        model.setDate(LocalDate.now());
        model.setPhotosUrl("DEFAULT");
        model.setDistance(request.getDistance_km().intValue());
        model.setTime(request.getDuration_time());
        model.setPace(request.getPace());
        model.setCaloriesBurned(request.getCaloriesBurned());
        model.setWeatherConditions(request.getWeatherConditions());
        model.setNotes(request.getNotes());
        model.setUserId(request.getUserId());
        RouteModel routeModel = new RouteModel();
        routeModel.setRoutePoints(convertToRoutePointModels(request.getRoute_points(), routeModel));
        model.setRoute(routeModel);
        if (request.getShoesId() != 0) model.setShoesId(request.getShoesId());
        if (request.getTraining_id_from_run_plan() != 0) model.setTraining(getTrainingEntityById(request.getTraining_id_from_run_plan()));
        return model;
    }

    private List<RoutePointModel> convertToRoutePointModels(List<RoutePointRequest> routePointRequests, RouteModel routeModel) {
        List<RoutePointModel> routePointModels = new ArrayList<>();

        for (RoutePointRequest routePointRequest : routePointRequests) {
            RoutePointModel routePointModel = new RoutePointModel();
            routePointModel.setLatitude(routePointRequest.getLatitude());
            routePointModel.setLongitude(routePointRequest.getLongitude());
            routePointModel.setRoute(routeModel);

            routePointModels.add(routePointModel);
        }

        return routePointModels;
    }

    private TrainingModel getTrainingEntityById(int id) {
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setId(id);
        return trainingModel;
    }
}
