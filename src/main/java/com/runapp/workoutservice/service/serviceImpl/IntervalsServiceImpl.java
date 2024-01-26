package com.runapp.workoutservice.service.serviceImpl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.IntervalModel;
import com.runapp.workoutservice.repository.IntervalsRepository;
import com.runapp.workoutservice.service.serviceTemplate.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervalsServiceImpl implements GenericService<IntervalModel> {

    private final IntervalsRepository intervalsRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(IntervalsServiceImpl.class);

    @Autowired
    public IntervalsServiceImpl(IntervalsRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }

    @Override
    public IntervalModel add(IntervalModel entity) {
        LOGGER.info("Interval add: {}", entity);
        return intervalsRepository.save(entity);
    }

    @Override
    public IntervalModel getById(Long id) {
        LOGGER.info("Interval get by id: {}", id);
        return intervalsRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Intervals with id: " + id + " doesn't exist"));
    }

    @Override
    public List<IntervalModel> getAll() {
        LOGGER.info("Interval get all");
        return intervalsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Interval delete by id: {}", id);
        if (!intervalsRepository.existsById(id)) {
            throw new NoEntityFoundException("Intervals with id: " + id + " doesn't exist");
        }
        intervalsRepository.deleteById(id);
    }

    @Override
    public IntervalModel update(IntervalModel entity) {
        LOGGER.info("Interval update: {}", entity);
        if (!intervalsRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("Intervals with id: " + entity.getId() + " doesn't exist");
        }
        return intervalsRepository.save(entity);
    }
}
