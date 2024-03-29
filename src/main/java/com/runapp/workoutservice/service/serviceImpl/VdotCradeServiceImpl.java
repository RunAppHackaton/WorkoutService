package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.VdotGradeModel;
import com.runapp.workoutservice.repository.VdotGradeRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class VdotCradeServiceImpl implements GenericService<VdotGradeModel> {

    private final VdotGradeRepository vdotGradeRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(VdotCradeServiceImpl.class);
    @Autowired
    public VdotCradeServiceImpl(VdotGradeRepository vdotGradeRepository) {
        this.vdotGradeRepository = vdotGradeRepository;
    }

    @Override
    @Caching(put = {@CachePut(value = "vdot", key = "#result.id")},
            evict = {@CacheEvict(value = "vdot", allEntries = true)})
    public VdotGradeModel add(VdotGradeModel entity) {
        LOGGER.info("VdotGrade add: {}", entity);
        return vdotGradeRepository.save(entity);
    }

    @Override
    @Cacheable(value = "vdot", key = "#vtod")
    public VdotGradeModel getById(Long vtod) {
        LOGGER.info("VdotGrade get by id: {}", vtod);
        return vdotGradeRepository.findById(vtod).orElseThrow(() -> new NoEntityFoundException("VDOT Grade with id: " + vtod + " doesn't exist"));
    }

    @Override
    @Cacheable(value = "vdot")
    public List<VdotGradeModel> getAll() {
        List<VdotGradeModel> vdotGradeModels = vdotGradeRepository.findAll();
        if (vdotGradeModels.isEmpty()) {
            LOGGER.warn("No VdotGrade records found in the database");
            throw new NoEntityFoundException("VdotGrade records doesn't exist");
        }
        LOGGER.info("VdotGrade get all");
        return vdotGradeModels;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "vdot", allEntries = true),
            @CacheEvict(value = "vdot", key = "#vtod")
    })
    public void deleteById(Long vtod) {
        LOGGER.info("VdotGrade delete by id: {}", vtod);
        if (!vdotGradeRepository.existsById(vtod)) {
            throw new NoEntityFoundException("VDOT Grade with id: " + vtod + " doesn't exist");
        }
        vdotGradeRepository.deleteById(vtod);
    }

    @Override
    @Caching(put = {@CachePut(value = "vdot", key = "#result.id")},
            evict = {@CacheEvict(value = "vdot", allEntries = true)})
    public VdotGradeModel update(VdotGradeModel entity) {
        LOGGER.info("VdotGrade update: {}", entity);
        if (!vdotGradeRepository.existsById(entity.getVdot())) {
            throw new NoEntityFoundException("VDOT Grade with id: " + entity.getVdot() + " doesn't exist");
        }
        return vdotGradeRepository.save(entity);
    }

    public VdotGradeModel findClosestTimeByDistanceAndTime(DistanceTypeEnum distanceTypeEnum, String time) {
        LOGGER.info("VdotGrade find closest time by Distance and Time: distanceTypeEnum={}, time={}", distanceTypeEnum, time);
        Duration duration = toDuration(time);
        VdotGradeModel vdotGradeModel = null;
        long timeInMintutes = toDuration(time).toMinutes();
        long min = Long.MAX_VALUE;
        try {
            List<VdotGradeModel> vdotGradeModels = vdotGradeRepository.findAll();
            int count = 0;

            for (VdotGradeModel model : vdotGradeModels) {
                count++;
                long currentValue = getTimeInMinutes(distanceTypeEnum, model);
                if (Math.abs(currentValue - timeInMintutes) < min) {
                    min = currentValue - timeInMintutes;
                    vdotGradeModel = model;
                }
            }
            return vdotGradeModel;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error occurred while processing numbers or array indices: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error occurred while passing an invalid argument: " + e.getMessage());
        }
        return null;
    }

    private long getTimeInMinutes(DistanceTypeEnum distanceType, VdotGradeModel vdotGradeModel) {
        LOGGER.info("Get time in minutes: distanceType={}, vdotGradeModel={}", distanceType, vdotGradeModel);
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
        }
        throw new RuntimeException(distanceType + ": this type of training does not exist(types of training: " +
                "\n 1.EASY_1500M " +
                "\n 2.EASY_MILE " +
                "\n 3.EASY_3000M " +
                "\n 4.EASY_2MILE " +
                "\n 5.EASY_5000M " +
                "\n 6.EASY_10000M " +
                "\n 7.EASY_15000M " +
                "\n 8.HALF_MARATHON " +
                "\n 9.MARATHON)");
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
        throw new RuntimeException(time + ": incorrect time format(the format should be in the form HH:MM:SS)");
    }
}
