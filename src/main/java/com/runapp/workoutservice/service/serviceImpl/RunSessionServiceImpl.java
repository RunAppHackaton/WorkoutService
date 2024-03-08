package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.utill.supportClasses.AchievementConverter;
import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.feignClient.AchievementServiceClient;
import com.runapp.workoutservice.feignClient.ShoesServiceClient;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.repository.RunSessionRepository;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import com.runapp.workoutservice.utill.existHandler.ExistEnum;
import com.runapp.workoutservice.utill.existHandler.ExistHandlerRegistry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RunSessionServiceImpl implements RunSessionService {

    private final RunSessionRepository runSessionRepository;
    private final ShoesServiceClient shoesServiceClient;
    private final ExistHandlerRegistry existHandlerRegistry;
    private final AchievementServiceClient achievementServiceClient;
    private final AchievementConverter achievementConverter;
    private final static Logger LOGGER = LoggerFactory.getLogger(RunSessionServiceImpl.class);

    @Override
    @Caching(put = {@CachePut(value = "run-session", key = "#result.id")},
            evict = {@CacheEvict(value = "run-session", allEntries = true)})
    public RunSessionModel add(RunSessionModel entity) {
        LOGGER.info("RunSession add: {}", entity);
        // convert and sent RunSession to Achievement Service for User Statistic
        achievementServiceClient.saveTraining(achievementConverter.convertToAchievementRequest(entity));
        existHandlerRegistry.handleRequest(ExistEnum.SHOES, entity.getShoesId());
        shoesServiceClient.updateMileage((long) entity.getShoesId(), entity.getDistance());

        return runSessionRepository.save(entity);
    }

    @Override
    @Cacheable(value = "run-session", key = "#id")
    public RunSessionModel getById(Long id) {
        LOGGER.info("RunSession get by id: {}", id);
        return runSessionRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("RunSession with id: " + id + " doesn't exist"));
    }

    @Override
    public List<RunSessionModel> getAll() {
        List<RunSessionModel> runSessionModels = runSessionRepository.findAll();
        if (runSessionModels.isEmpty()) {
            LOGGER.warn("No RunSessions records found in the database");
            throw new NoEntityFoundException("RunSessions records doesn't exist");
        }
        LOGGER.info("RunSession get all");
        return runSessionModels;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "run-session", allEntries = true),
            @CacheEvict(value = "run-session", key = "#id")
    })
    public void deleteById(Long id) {
        LOGGER.info("RunSession delete by id: {}", id);
        if (!runSessionRepository.existsById(id)) {
            throw new NoEntityFoundException("RunSession with id: " + id + " doesn't exist");
        }
        runSessionRepository.deleteById(id);
    }

    @Override
    @Caching(put = {@CachePut(value = "run-session", key = "#result.id")},
            evict = {@CacheEvict(value = "run-session", allEntries = true)})
    public RunSessionModel update(RunSessionModel entity) {
        LOGGER.info("RunSession update: {}", entity);
        existHandlerRegistry.handleRequest(ExistEnum.SHOES, entity.getShoesId());

        if (!runSessionRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("RunSession with id: " + entity.getId() + " doesn't exist");
        }
        return runSessionRepository.save(entity);
    }
}
