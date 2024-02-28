package com.runapp.workoutservice.service;

import com.runapp.workoutservice.service.serviceImpl.RunPlanGenerator;
import com.runapp.workoutservice.service.serviceImpl.VdotCradeServiceImpl;
import com.runapp.workoutservice.service.serviceImpl.VdotWorkoutServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RunPlanGeneratorTest {
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calculatePercentage_ValidInput_ReturnsCorrectResult() {
        // Test with valid input within the range [0, 100]
        assertEquals(50, RunPlanGenerator.calculatePercentage(100, 50)); // 50% of 100
        assertEquals(25, RunPlanGenerator.calculatePercentage(200, 12.5)); // 12.5% of 200
        assertEquals(0, RunPlanGenerator.calculatePercentage(150, 0)); // 0% of 150
        assertEquals(75, RunPlanGenerator.calculatePercentage(80, 93.75)); // 93.75% of 80
    }

    @Test
    void calculatePercentage_InvalidInput_OutsideRange_ThrowsIllegalArgumentException() {
        // Test with invalid input outside the range [0, 100]
        assertThrows(IllegalArgumentException.class, () -> RunPlanGenerator.calculatePercentage(100, -10)); // Negative percentage
        assertThrows(IllegalArgumentException.class, () -> RunPlanGenerator.calculatePercentage(200, 110)); // Percentage greater than 100
    }

    @Test
    void calculatePercentage_CalculationAccuracy_ReturnsCorrectRoundedValue() {
        // Test to verify the rounding behavior
        assertEquals(33, RunPlanGenerator.calculatePercentage(99, 33.333)); // 33.333% of 99
        assertEquals(67, RunPlanGenerator.calculatePercentage(100, 66.6666)); // 66.6666% of 100
        assertEquals(25, RunPlanGenerator.calculatePercentage(100, 25.1)); // 25.1% of 100 (rounded down)
        assertEquals(75, RunPlanGenerator.calculatePercentage(100, 74.9)); // 74.9% of 100 (rounded up)
    }
}
