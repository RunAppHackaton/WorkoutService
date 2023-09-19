package com.runapp.workoutservice.service.Impl;

import com.runapp.workoutservice.exception.NoEntityFoundException;
import com.runapp.workoutservice.model.IntervalsModel;
import com.runapp.workoutservice.repository.IntervalsRepository;
import com.runapp.workoutservice.service.IntervalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervalsServiceImpl implements IntervalsService {

    private final IntervalsRepository intervalsRepository;

    @Autowired
    public IntervalsServiceImpl(IntervalsRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }

    @Override
    public IntervalsModel add(IntervalsModel entity) {
        return intervalsRepository.save(entity);
    }

    @Override
    public IntervalsModel getById(Long id) {
        return intervalsRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Intervals with id: " + id + " doesn't exist"));
    }

    @Override
    public List<IntervalsModel> getAll() {
        return intervalsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!intervalsRepository.existsById(id)) {
            throw new NoEntityFoundException("Intervals with id: " + id + " doesn't exist");
        }
        intervalsRepository.deleteById(id);
    }

    @Override
    public IntervalsModel update(IntervalsModel entity) {
        if (!intervalsRepository.existsById(entity.getId())) {
            throw new NoEntityFoundException("Intervals with id: " + entity.getId() + " doesn't exist");
        }
        return intervalsRepository.save(entity);
    }
}
