package com.runapp.workoutservice.staticObject;

import com.runapp.workoutservice.dto.request.VdotGradeRequest;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.model.VdotWorkoutModel;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;

public class StaticVdot {

    public static VdotGradeModel vdotGradeModel(){
        VdotGradeModel vdotGradeModel = new VdotGradeModel();
        vdotGradeModel.setEasy10000m("Easy10000m");
        vdotGradeModel.setEasy15000m("Easy15000m");
        vdotGradeModel.setEasy1500m("Easy1500m");
        vdotGradeModel.setEasy2Mile("Easy2 Mile");
        vdotGradeModel.setEasy3000m("Easy3000m");
        vdotGradeModel.setEasy5000m("Easy5000m");
        vdotGradeModel.setEasyMile("Easy Mile");
        vdotGradeModel.setHalfMarathon("Half Marathon");
        vdotGradeModel.setMarathon("Marathon");
        vdotGradeModel.setVdot(1L);
        return vdotGradeModel;
    }

    public static VdotWorkoutModel vdotWorkoutModel(){
        VdotWorkoutModel vdotWorkoutModel = new VdotWorkoutModel();
        vdotWorkoutModel.setEasyKm("Easy Km");
        vdotWorkoutModel.setEasyMi("Easy Mi");
        vdotWorkoutModel.setInterval_1000m("Interval 1000m");
        vdotWorkoutModel.setInterval_1200m("Interval 1200m");
        vdotWorkoutModel.setInterval_400m("Interval 400m");
        vdotWorkoutModel.setInterval_mi("Interval mi");
        vdotWorkoutModel.setMarathonKm("Marathon Km");
        vdotWorkoutModel.setMarathonMi("Marathon Mi");
        vdotWorkoutModel.setRepetition_200m("Bella");
        vdotWorkoutModel.setRepetition_400m("Bella");
        vdotWorkoutModel.setRepetition_800m("Bella");
        vdotWorkoutModel.setThreshold_1000m("Threshold 1000m");
        vdotWorkoutModel.setThreshold_400m("Threshold 400m");
        vdotWorkoutModel.setThreshold_mi("Threshold mi");
        vdotWorkoutModel.setVdot(1L);
        return vdotWorkoutModel;
    }

    public static VdotGradeRequest vdotGradeRequest1(){
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest();
        vdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        vdotGradeRequest.setTime("Time");
        return vdotGradeRequest;
    }

    public static VdotGradeRequest vdotGradeRequest2(){
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest();
        vdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        vdotGradeRequest.setTime("99:09:09");
        return vdotGradeRequest;
    }
}
