package com.runapp.workoutservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {TrainingAchievementRequest.class})
@ExtendWith(SpringExtension.class)
class TrainingAchievementRequestDiffblueTest {
    @Autowired
    private TrainingAchievementRequest trainingAchievementRequest;

    /**
     * Method under test: {@link TrainingAchievementRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new TrainingAchievementRequest()).canEqual("Other"));
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();

        TrainingAchievementRequest trainingAchievementRequest3 = new TrainingAchievementRequest();
        trainingAchievementRequest3.setDistance_km(3);
        trainingAchievementRequest3.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest3.setUserId(1L);
        assertTrue(trainingAchievementRequest2.canEqual(trainingAchievementRequest3));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of
     * {@link TrainingAchievementRequest}
     *   <li>{@link TrainingAchievementRequest#setDistance_km(int)}
     *   <li>{@link TrainingAchievementRequest#setPace(Duration)}
     *   <li>{@link TrainingAchievementRequest#setTraining_date(LocalDate)}
     *   <li>{@link TrainingAchievementRequest#setTraining_duration(Duration)}
     *   <li>{@link TrainingAchievementRequest#setUserId(Long)}
     *   <li>{@link TrainingAchievementRequest#toString()}
     *   <li>{@link TrainingAchievementRequest#getDistance_km()}
     *   <li>{@link TrainingAchievementRequest#getPace()}
     *   <li>{@link TrainingAchievementRequest#getTraining_date()}
     *   <li>{@link TrainingAchievementRequest#getTraining_duration()}
     *   <li>{@link TrainingAchievementRequest#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TrainingAchievementRequest actualTrainingAchievementRequest = new TrainingAchievementRequest();
        actualTrainingAchievementRequest.setDistance_km(1);
        actualTrainingAchievementRequest.setPace(null);
        LocalDate training_date = LocalDate.of(1970, 1, 1);
        actualTrainingAchievementRequest.setTraining_date(training_date);
        actualTrainingAchievementRequest.setTraining_duration(null);
        actualTrainingAchievementRequest.setUserId(1L);
        String actualToStringResult = actualTrainingAchievementRequest.toString();
        int actualDistance_km = actualTrainingAchievementRequest.getDistance_km();
        actualTrainingAchievementRequest.getPace();
        LocalDate actualTraining_date = actualTrainingAchievementRequest.getTraining_date();
        actualTrainingAchievementRequest.getTraining_duration();
        assertEquals(
                "TrainingAchievementRequest(training_date=1970-01-01, distance_km=1, training_duration=null, pace=null,"
                        + " userId=1)",
                actualToStringResult);
        assertEquals(1, actualDistance_km);
        assertEquals(1L, actualTrainingAchievementRequest.getUserId().longValue());
        assertSame(training_date, actualTraining_date);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, null);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals2() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, "Different type to TrainingAchievementRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingAchievementRequest#equals(Object)}
     *   <li>{@link TrainingAchievementRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(1L);
        assertEquals(trainingAchievementRequest, trainingAchievementRequest);
        int expectedHashCodeResult = trainingAchievementRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingAchievementRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingAchievementRequest#equals(Object)}
     *   <li>{@link TrainingAchievementRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(1L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertEquals(trainingAchievementRequest, trainingAchievementRequest2);
        int expectedHashCodeResult = trainingAchievementRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingAchievementRequest2.hashCode());
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(3);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(1L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, trainingAchievementRequest2);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.now());
        trainingAchievementRequest.setUserId(1L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, trainingAchievementRequest2);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(null);
        trainingAchievementRequest.setUserId(1L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, trainingAchievementRequest2);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(2L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, trainingAchievementRequest2);
    }

    /**
     * Method under test: {@link TrainingAchievementRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(null);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(1L);
        assertNotEquals(trainingAchievementRequest, trainingAchievementRequest2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingAchievementRequest#equals(Object)}
     *   <li>{@link TrainingAchievementRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(null);
        trainingAchievementRequest.setUserId(1L);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(null);
        trainingAchievementRequest2.setUserId(1L);
        assertEquals(trainingAchievementRequest, trainingAchievementRequest2);
        int expectedHashCodeResult = trainingAchievementRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingAchievementRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TrainingAchievementRequest#equals(Object)}
     *   <li>{@link TrainingAchievementRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        TrainingAchievementRequest trainingAchievementRequest = new TrainingAchievementRequest();
        trainingAchievementRequest.setDistance_km(1);
        trainingAchievementRequest.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest.setUserId(null);

        TrainingAchievementRequest trainingAchievementRequest2 = new TrainingAchievementRequest();
        trainingAchievementRequest2.setDistance_km(1);
        trainingAchievementRequest2.setTraining_date(LocalDate.of(1970, 1, 1));
        trainingAchievementRequest2.setUserId(null);
        assertEquals(trainingAchievementRequest, trainingAchievementRequest2);
        int expectedHashCodeResult = trainingAchievementRequest.hashCode();
        assertEquals(expectedHashCodeResult, trainingAchievementRequest2.hashCode());
    }
}
