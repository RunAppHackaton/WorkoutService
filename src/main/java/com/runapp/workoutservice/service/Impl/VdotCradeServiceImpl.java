package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.repository.VdotGradeRepository;
import com.runapp.workoutservice.service.VdotGradeService;
import com.runapp.workoutservice.utill.DistanceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class VdotCradeServiceImpl implements VdotGradeService {

    private final VdotGradeRepository vdotGradeRepository;

    @Autowired
    public VdotCradeServiceImpl(VdotGradeRepository vdotGradeRepository) {
        this.vdotGradeRepository = vdotGradeRepository;
    }

    @Override
    public VdotGradeModel add(VdotGradeModel entity) {
        return vdotGradeRepository.save(entity);
    }

    @Override
    public VdotGradeModel getById(Long vtod) {
        return vdotGradeRepository.findById(vtod).orElseThrow(() -> new NoEntityFoundException("VDOT Grade with id: " + vtod + " doesn't exist"));
    }

    @Override
    public List<VdotGradeModel> getAll() {
        return vdotGradeRepository.findAll();
    }

    @Override
    public void deleteById(Long vtod) {
        if (!vdotGradeRepository.existsById(vtod)) {
            throw new NoEntityFoundException("VDOT Grade with id: " + vtod + " doesn't exist");
        }
        vdotGradeRepository.deleteById(vtod);
    }

    @Override
    public VdotGradeModel update(VdotGradeModel entity) {
        if (!vdotGradeRepository.existsById(entity.getVdot())) {
            throw new NoEntityFoundException("VDOT Grade with id: " + entity.getVdot() + " doesn't exist");
        }
        return vdotGradeRepository.save(entity);
    }

    public VdotGradeModel findClosestTimeByDistanceAndTime(DistanceTypeEnum distanceTypeEnum, String time) {
        Duration duration = toDuration(time);
        VdotGradeModel vdotGradeModel = null;
        long timeInMintutes = toDuration(time).toMinutes();
        long min = Long.MAX_VALUE;
        try {
            List<VdotGradeModel> vdotGradeModels = vdotGradeRepository.findAll();

            for (VdotGradeModel model : vdotGradeModels) {
                long currentValue = getTimeInMinutes(distanceTypeEnum, model);
                if (Math.abs(currentValue - timeInMintutes) < min) {
                    min = currentValue - timeInMintutes;
                    vdotGradeModel = model;
                }
            }
            return vdotGradeModel;

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Если время в неправильном формате, возвращаем null
            return null; //todo throw Exception
        } catch (IllegalArgumentException e) {
            return null; //todo throw Exception
        }
    }

    private long getTimeInMinutes(DistanceTypeEnum distanceType, VdotGradeModel vdotGradeModel) {
        switch (distanceType) {
            case EASY_1500M -> {
                return toDuration(vdotGradeModel.getEasy1500m()).toMinutes();
            }
            case EASY_MILE -> {
                return toDuration(vdotGradeModel.getEasyMile()).toMinutes();
            }
            case EASY_3000M -> {
                return toDuration(vdotGradeModel.getEasy3000m()).toMinutes();
            }
            case EASY_2MILE -> {
                return toDuration(vdotGradeModel.getEasy2Mile()).toMinutes();
            }
            case EASY_5000M -> {
                return toDuration(vdotGradeModel.getEasy5000m()).toMinutes();
            }
            case EASY_10000M -> {
                return toDuration(vdotGradeModel.getEasy10000m()).toMinutes();
            }
            case EASY_15000M -> {
                return toDuration(vdotGradeModel.getEasy15000m()).toMinutes();
            }
            case HALF_MARATHON -> {
                return toDuration(vdotGradeModel.getHalfMarathon()).toMinutes();
            }
            case MARATHON -> {
                return toDuration(vdotGradeModel.getMarathon()).toMinutes();
            }
            default -> {
                throw new IllegalArgumentException(distanceType.name() + " does not exist");
            }
        }
    }

    private Duration toDuration(String time) {
        String[] timeParts = time.split(":");
        if (timeParts.length == 1) {
            int seconds = Integer.parseInt(timeParts[0]);
            return Duration.ofHours(0).plusMinutes(0).plusSeconds(seconds);
        } else if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            return Duration.ofHours(0).plusMinutes(minutes).plusSeconds(seconds);
        } else if (timeParts.length == 3) {
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int seconds = Integer.parseInt(timeParts[2]);
            return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        }
        return null;
    }
}
