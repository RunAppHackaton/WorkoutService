package com.runapp.workoutservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import com.runapp.workoutservice.utill.enums.RunPlanEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RunPlanRequest.class})
@ExtendWith(SpringExtension.class)
class RunPlanRequestDiffblueTest {
    @Autowired
    private RunPlanRequest runPlanRequest;

    /**
     * Method under test: {@link RunPlanRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(runPlanRequest.canEqual("Other"));
        assertTrue(runPlanRequest.canEqual(runPlanRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunPlanRequest#RunPlanRequest()}
     *   <li>{@link RunPlanRequest#setGoal_date(LocalDate)}
     *   <li>{@link RunPlanRequest#setKilometers_per_week(int)}
     *   <li>{@link RunPlanRequest#setNumber_of_workouts_per_week(int)}
     *   <li>{@link RunPlanRequest#setRunPlanEnum(RunPlanEnum)}
     *   <li>{@link RunPlanRequest#setTarget_time(String)}
     *   <li>{@link RunPlanRequest#setTime_at_which_you_ran(String)}
     *   <li>{@link RunPlanRequest#setTraining_days(DayOfWeek[])}
     *   <li>{@link RunPlanRequest#setType_were_you_running(DistanceTypeEnum)}
     *   <li>{@link RunPlanRequest#setUser_id(int)}
     *   <li>{@link RunPlanRequest#toString()}
     *   <li>{@link RunPlanRequest#getGoal_date()}
     *   <li>{@link RunPlanRequest#getKilometers_per_week()}
     *   <li>{@link RunPlanRequest#getNumber_of_workouts_per_week()}
     *   <li>{@link RunPlanRequest#getRunPlanEnum()}
     *   <li>{@link RunPlanRequest#getTarget_time()}
     *   <li>{@link RunPlanRequest#getTime_at_which_you_ran()}
     *   <li>{@link RunPlanRequest#getTraining_days()}
     *   <li>{@link RunPlanRequest#getType_were_you_running()}
     *   <li>{@link RunPlanRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RunPlanRequest actualRunPlanRequest = new RunPlanRequest();
        LocalDate goal_date = LocalDate.of(1970, 1, 1);
        actualRunPlanRequest.setGoal_date(goal_date);
        actualRunPlanRequest.setKilometers_per_week(1);
        actualRunPlanRequest.setNumber_of_workouts_per_week(10);
        actualRunPlanRequest.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        actualRunPlanRequest.setTarget_time("Target time");
        actualRunPlanRequest.setTime_at_which_you_ran("Time at which you ran");
        DayOfWeek[] training_days = new DayOfWeek[]{DayOfWeek.MONDAY};
        actualRunPlanRequest.setTraining_days(training_days);
        actualRunPlanRequest.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        actualRunPlanRequest.setUser_id(1);
        String actualToStringResult = actualRunPlanRequest.toString();
        LocalDate actualGoal_date = actualRunPlanRequest.getGoal_date();
        int actualKilometers_per_week = actualRunPlanRequest.getKilometers_per_week();
        int actualNumber_of_workouts_per_week = actualRunPlanRequest.getNumber_of_workouts_per_week();
        RunPlanEnum actualRunPlanEnum = actualRunPlanRequest.getRunPlanEnum();
        String actualTarget_time = actualRunPlanRequest.getTarget_time();
        String actualTime_at_which_you_ran = actualRunPlanRequest.getTime_at_which_you_ran();
        DayOfWeek[] actualTraining_days = actualRunPlanRequest.getTraining_days();
        DistanceTypeEnum actualType_were_you_running = actualRunPlanRequest.getType_were_you_running();
        assertEquals("RunPlanRequest(user_id=1, runPlanEnum=PLAN_5000M, goal_date=1970-01-01, target_time=Target time,"
                + " type_were_you_running=EASY_1500M, time_at_which_you_ran=Time at which you ran, kilometers_per_week=1,"
                + " number_of_workouts_per_week=10, training_days=[MONDAY])", actualToStringResult);
        assertEquals("Target time", actualTarget_time);
        assertEquals("Time at which you ran", actualTime_at_which_you_ran);
        assertEquals(1, actualKilometers_per_week);
        assertEquals(1, actualRunPlanRequest.getUser_id());
        assertEquals(10, actualNumber_of_workouts_per_week);
        assertEquals(DistanceTypeEnum.EASY_1500M, actualType_were_you_running);
        assertEquals(RunPlanEnum.PLAN_5000M, actualRunPlanEnum);
        assertSame(goal_date, actualGoal_date);
        assertSame(training_days, actualTraining_days);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link RunPlanRequest#RunPlanRequest(int, RunPlanEnum, LocalDate, String, DistanceTypeEnum, String, int, int, DayOfWeek[])}
     *   <li>{@link RunPlanRequest#setGoal_date(LocalDate)}
     *   <li>{@link RunPlanRequest#setKilometers_per_week(int)}
     *   <li>{@link RunPlanRequest#setNumber_of_workouts_per_week(int)}
     *   <li>{@link RunPlanRequest#setRunPlanEnum(RunPlanEnum)}
     *   <li>{@link RunPlanRequest#setTarget_time(String)}
     *   <li>{@link RunPlanRequest#setTime_at_which_you_ran(String)}
     *   <li>{@link RunPlanRequest#setTraining_days(DayOfWeek[])}
     *   <li>{@link RunPlanRequest#setType_were_you_running(DistanceTypeEnum)}
     *   <li>{@link RunPlanRequest#setUser_id(int)}
     *   <li>{@link RunPlanRequest#toString()}
     *   <li>{@link RunPlanRequest#getGoal_date()}
     *   <li>{@link RunPlanRequest#getKilometers_per_week()}
     *   <li>{@link RunPlanRequest#getNumber_of_workouts_per_week()}
     *   <li>{@link RunPlanRequest#getRunPlanEnum()}
     *   <li>{@link RunPlanRequest#getTarget_time()}
     *   <li>{@link RunPlanRequest#getTime_at_which_you_ran()}
     *   <li>{@link RunPlanRequest#getTraining_days()}
     *   <li>{@link RunPlanRequest#getType_were_you_running()}
     *   <li>{@link RunPlanRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        RunPlanRequest actualRunPlanRequest = new RunPlanRequest(1, RunPlanEnum.PLAN_5000M, LocalDate.of(1970, 1, 1),
                "Target time", DistanceTypeEnum.EASY_1500M, "Time at which you ran", 1, 10, new DayOfWeek[]{DayOfWeek.MONDAY});
        LocalDate goal_date = LocalDate.of(1970, 1, 1);
        actualRunPlanRequest.setGoal_date(goal_date);
        actualRunPlanRequest.setKilometers_per_week(1);
        actualRunPlanRequest.setNumber_of_workouts_per_week(10);
        actualRunPlanRequest.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        actualRunPlanRequest.setTarget_time("Target time");
        actualRunPlanRequest.setTime_at_which_you_ran("Time at which you ran");
        DayOfWeek[] training_days = new DayOfWeek[]{DayOfWeek.MONDAY};
        actualRunPlanRequest.setTraining_days(training_days);
        actualRunPlanRequest.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        actualRunPlanRequest.setUser_id(1);
        String actualToStringResult = actualRunPlanRequest.toString();
        LocalDate actualGoal_date = actualRunPlanRequest.getGoal_date();
        int actualKilometers_per_week = actualRunPlanRequest.getKilometers_per_week();
        int actualNumber_of_workouts_per_week = actualRunPlanRequest.getNumber_of_workouts_per_week();
        RunPlanEnum actualRunPlanEnum = actualRunPlanRequest.getRunPlanEnum();
        String actualTarget_time = actualRunPlanRequest.getTarget_time();
        String actualTime_at_which_you_ran = actualRunPlanRequest.getTime_at_which_you_ran();
        DayOfWeek[] actualTraining_days = actualRunPlanRequest.getTraining_days();
        DistanceTypeEnum actualType_were_you_running = actualRunPlanRequest.getType_were_you_running();
        assertEquals("RunPlanRequest(user_id=1, runPlanEnum=PLAN_5000M, goal_date=1970-01-01, target_time=Target time,"
                + " type_were_you_running=EASY_1500M, time_at_which_you_ran=Time at which you ran, kilometers_per_week=1,"
                + " number_of_workouts_per_week=10, training_days=[MONDAY])", actualToStringResult);
        assertEquals("Target time", actualTarget_time);
        assertEquals("Time at which you ran", actualTime_at_which_you_ran);
        assertEquals(1, actualKilometers_per_week);
        assertEquals(1, actualRunPlanRequest.getUser_id());
        assertEquals(10, actualNumber_of_workouts_per_week);
        assertEquals(DistanceTypeEnum.EASY_1500M, actualType_were_you_running);
        assertEquals(RunPlanEnum.PLAN_5000M, actualRunPlanEnum);
        assertSame(goal_date, actualGoal_date);
        assertSame(training_days, actualTraining_days);
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RunPlanRequest(), null);
        assertNotEquals(new RunPlanRequest(), "Different type to RunPlanRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunPlanRequest#equals(Object)}
     *   <li>{@link RunPlanRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        assertEquals(runPlanRequest, runPlanRequest);
        int expectedHashCodeResult = runPlanRequest.hashCode();
        assertEquals(expectedHashCodeResult, runPlanRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunPlanRequest#equals(Object)}
     *   <li>{@link RunPlanRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        assertEquals(runPlanRequest, runPlanRequest2);
        int expectedHashCodeResult = runPlanRequest.hashCode();
        assertEquals(expectedHashCodeResult, runPlanRequest2.hashCode());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RunPlanRequest runPlanRequest = new RunPlanRequest(1, RunPlanEnum.PLAN_5000M, LocalDate.of(1970, 1, 1),
                "Target time", DistanceTypeEnum.EASY_1500M, "Time at which you ran", 1, 10, new DayOfWeek[]{DayOfWeek.MONDAY});
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setGoal_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setTarget_time("Target time");
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setTime_at_which_you_ran("Time at which you ran");
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setKilometers_per_week(1);
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setNumber_of_workouts_per_week(10);
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();
        runPlanRequest.setTraining_days(new DayOfWeek[]{DayOfWeek.MONDAY});
        assertNotEquals(runPlanRequest, new RunPlanRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunPlanRequest#equals(Object)}
     *   <li>{@link RunPlanRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        RunPlanRequest runPlanRequest = new RunPlanRequest(1, RunPlanEnum.PLAN_5000M, LocalDate.of(1970, 1, 1),
                "Target time", DistanceTypeEnum.EASY_1500M, "Time at which you ran", 1, 10, new DayOfWeek[]{DayOfWeek.MONDAY});
        RunPlanRequest runPlanRequest2 = new RunPlanRequest(1, RunPlanEnum.PLAN_5000M, LocalDate.of(1970, 1, 1),
                "Target time", DistanceTypeEnum.EASY_1500M, "Time at which you ran", 1, 10, new DayOfWeek[]{DayOfWeek.MONDAY});

        assertEquals(runPlanRequest, runPlanRequest2);
        int expectedHashCodeResult = runPlanRequest.hashCode();
        assertEquals(expectedHashCodeResult, runPlanRequest2.hashCode());
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals14() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();

        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        runPlanRequest2.setRunPlanEnum(RunPlanEnum.PLAN_5000M);
        assertNotEquals(runPlanRequest, runPlanRequest2);
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals15() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();

        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        runPlanRequest2.setGoal_date(LocalDate.of(1970, 1, 1));
        assertNotEquals(runPlanRequest, runPlanRequest2);
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals16() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();

        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        runPlanRequest2.setTarget_time("Target time");
        assertNotEquals(runPlanRequest, runPlanRequest2);
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals17() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();

        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        runPlanRequest2.setType_were_you_running(DistanceTypeEnum.EASY_1500M);
        assertNotEquals(runPlanRequest, runPlanRequest2);
    }

    /**
     * Method under test: {@link RunPlanRequest#equals(Object)}
     */
    @Test
    void testEquals18() {
        RunPlanRequest runPlanRequest = new RunPlanRequest();

        RunPlanRequest runPlanRequest2 = new RunPlanRequest();
        runPlanRequest2.setTime_at_which_you_ran("Time at which you ran");
        assertNotEquals(runPlanRequest, runPlanRequest2);
    }
}
