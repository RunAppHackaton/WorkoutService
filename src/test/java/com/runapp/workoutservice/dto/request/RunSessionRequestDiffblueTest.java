package com.runapp.workoutservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RunSessionRequest.class})
@ExtendWith(SpringExtension.class)
class RunSessionRequestDiffblueTest {
    @Autowired
    private RunSessionRequest runSessionRequest;

    /**
     * Method under test: {@link RunSessionRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(runSessionRequest.canEqual("Other"));
        assertTrue(runSessionRequest.canEqual(runSessionRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunSessionRequest#RunSessionRequest()}
     *   <li>{@link RunSessionRequest#setCaloriesBurned(int)}
     *   <li>{@link RunSessionRequest#setDistance_km(BigDecimal)}
     *   <li>{@link RunSessionRequest#setDuration_time(Duration)}
     *   <li>{@link RunSessionRequest#setNotes(String)}
     *   <li>{@link RunSessionRequest#setPace(Duration)}
     *   <li>{@link RunSessionRequest#setRouteId(int)}
     *   <li>{@link RunSessionRequest#setRoute_points(List)}
     *   <li>{@link RunSessionRequest#setShoesId(int)}
     *   <li>{@link RunSessionRequest#setTraining_id_from_run_plan(int)}
     *   <li>{@link RunSessionRequest#setUserId(int)}
     *   <li>{@link RunSessionRequest#setWeatherConditions(String)}
     *   <li>{@link RunSessionRequest#toString()}
     *   <li>{@link RunSessionRequest#getCaloriesBurned()}
     *   <li>{@link RunSessionRequest#getDistance_km()}
     *   <li>{@link RunSessionRequest#getDuration_time()}
     *   <li>{@link RunSessionRequest#getNotes()}
     *   <li>{@link RunSessionRequest#getPace()}
     *   <li>{@link RunSessionRequest#getRouteId()}
     *   <li>{@link RunSessionRequest#getRoute_points()}
     *   <li>{@link RunSessionRequest#getShoesId()}
     *   <li>{@link RunSessionRequest#getTraining_id_from_run_plan()}
     *   <li>{@link RunSessionRequest#getUserId()}
     *   <li>{@link RunSessionRequest#getWeatherConditions()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RunSessionRequest actualRunSessionRequest = new RunSessionRequest();
        actualRunSessionRequest.setCaloriesBurned(1);
        BigDecimal distance_km = new BigDecimal("2.3");
        actualRunSessionRequest.setDistance_km(distance_km);
        actualRunSessionRequest.setDuration_time(null);
        actualRunSessionRequest.setNotes("Notes");
        actualRunSessionRequest.setPace(null);
        actualRunSessionRequest.setRouteId(1);
        ArrayList<RoutePointRequest> route_points = new ArrayList<>();
        actualRunSessionRequest.setRoute_points(route_points);
        actualRunSessionRequest.setShoesId(1);
        actualRunSessionRequest.setTraining_id_from_run_plan(1);
        actualRunSessionRequest.setUserId(1);
        actualRunSessionRequest.setWeatherConditions("Weather Conditions");
        String actualToStringResult = actualRunSessionRequest.toString();
        int actualCaloriesBurned = actualRunSessionRequest.getCaloriesBurned();
        BigDecimal actualDistance_km = actualRunSessionRequest.getDistance_km();
        actualRunSessionRequest.getDuration_time();
        String actualNotes = actualRunSessionRequest.getNotes();
        actualRunSessionRequest.getPace();
        int actualRouteId = actualRunSessionRequest.getRouteId();
        List<RoutePointRequest> actualRoute_points = actualRunSessionRequest.getRoute_points();
        int actualShoesId = actualRunSessionRequest.getShoesId();
        int actualTraining_id_from_run_plan = actualRunSessionRequest.getTraining_id_from_run_plan();
        int actualUserId = actualRunSessionRequest.getUserId();
        assertEquals("Notes", actualNotes);
        assertEquals("RunSessionRequest(distance_km=2.3, duration_time=null, caloriesBurned=1, notes=Notes, routeId=1,"
                + " shoesId=1, userId=1, route_points=[], training_id_from_run_plan=1, weatherConditions=Weather Conditions,"
                + " pace=null)", actualToStringResult);
        assertEquals("Weather Conditions", actualRunSessionRequest.getWeatherConditions());
        assertEquals(1, actualCaloriesBurned);
        assertEquals(1, actualRouteId);
        assertEquals(1, actualShoesId);
        assertEquals(1, actualTraining_id_from_run_plan);
        assertEquals(1, actualUserId);
        assertEquals(new BigDecimal("2.3"), actualDistance_km);
        assertSame(distance_km, actualDistance_km);
        assertSame(route_points, actualRoute_points);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link RunSessionRequest#RunSessionRequest(BigDecimal, Duration, int, String, int, int, int, List, int, String, Duration)}
     *   <li>{@link RunSessionRequest#setCaloriesBurned(int)}
     *   <li>{@link RunSessionRequest#setDistance_km(BigDecimal)}
     *   <li>{@link RunSessionRequest#setDuration_time(Duration)}
     *   <li>{@link RunSessionRequest#setNotes(String)}
     *   <li>{@link RunSessionRequest#setPace(Duration)}
     *   <li>{@link RunSessionRequest#setRouteId(int)}
     *   <li>{@link RunSessionRequest#setRoute_points(List)}
     *   <li>{@link RunSessionRequest#setShoesId(int)}
     *   <li>{@link RunSessionRequest#setTraining_id_from_run_plan(int)}
     *   <li>{@link RunSessionRequest#setUserId(int)}
     *   <li>{@link RunSessionRequest#setWeatherConditions(String)}
     *   <li>{@link RunSessionRequest#toString()}
     *   <li>{@link RunSessionRequest#getCaloriesBurned()}
     *   <li>{@link RunSessionRequest#getDistance_km()}
     *   <li>{@link RunSessionRequest#getDuration_time()}
     *   <li>{@link RunSessionRequest#getNotes()}
     *   <li>{@link RunSessionRequest#getPace()}
     *   <li>{@link RunSessionRequest#getRouteId()}
     *   <li>{@link RunSessionRequest#getRoute_points()}
     *   <li>{@link RunSessionRequest#getShoesId()}
     *   <li>{@link RunSessionRequest#getTraining_id_from_run_plan()}
     *   <li>{@link RunSessionRequest#getUserId()}
     *   <li>{@link RunSessionRequest#getWeatherConditions()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        BigDecimal distance_km = new BigDecimal("2.3");
        ArrayList<RoutePointRequest> route_points = new ArrayList<>();
        RunSessionRequest actualRunSessionRequest = new RunSessionRequest(distance_km, null, 1, "Notes", 1, 1, 1,
                route_points, 1, "Weather Conditions", null);
        actualRunSessionRequest.setCaloriesBurned(1);
        BigDecimal distance_km2 = new BigDecimal("2.3");
        actualRunSessionRequest.setDistance_km(distance_km2);
        actualRunSessionRequest.setDuration_time(null);
        actualRunSessionRequest.setNotes("Notes");
        actualRunSessionRequest.setPace(null);
        actualRunSessionRequest.setRouteId(1);
        ArrayList<RoutePointRequest> route_points2 = new ArrayList<>();
        actualRunSessionRequest.setRoute_points(route_points2);
        actualRunSessionRequest.setShoesId(1);
        actualRunSessionRequest.setTraining_id_from_run_plan(1);
        actualRunSessionRequest.setUserId(1);
        actualRunSessionRequest.setWeatherConditions("Weather Conditions");
        String actualToStringResult = actualRunSessionRequest.toString();
        int actualCaloriesBurned = actualRunSessionRequest.getCaloriesBurned();
        BigDecimal actualDistance_km = actualRunSessionRequest.getDistance_km();
        actualRunSessionRequest.getDuration_time();
        String actualNotes = actualRunSessionRequest.getNotes();
        actualRunSessionRequest.getPace();
        int actualRouteId = actualRunSessionRequest.getRouteId();
        List<RoutePointRequest> actualRoute_points = actualRunSessionRequest.getRoute_points();
        int actualShoesId = actualRunSessionRequest.getShoesId();
        int actualTraining_id_from_run_plan = actualRunSessionRequest.getTraining_id_from_run_plan();
        int actualUserId = actualRunSessionRequest.getUserId();
        assertEquals("Notes", actualNotes);
        assertEquals("RunSessionRequest(distance_km=2.3, duration_time=null, caloriesBurned=1, notes=Notes, routeId=1,"
                + " shoesId=1, userId=1, route_points=[], training_id_from_run_plan=1, weatherConditions=Weather Conditions,"
                + " pace=null)", actualToStringResult);
        assertEquals("Weather Conditions", actualRunSessionRequest.getWeatherConditions());
        assertEquals(1, actualCaloriesBurned);
        assertEquals(1, actualRouteId);
        assertEquals(1, actualShoesId);
        assertEquals(1, actualTraining_id_from_run_plan);
        assertEquals(1, actualUserId);
        assertEquals(new BigDecimal("2.3"), actualDistance_km);
        assertEquals(route_points, actualRoute_points);
        assertSame(distance_km2, actualDistance_km);
        assertSame(route_points2, actualRoute_points);
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RunSessionRequest(), null);
        assertNotEquals(new RunSessionRequest(), "Different type to RunSessionRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunSessionRequest#equals(Object)}
     *   <li>{@link RunSessionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        assertEquals(runSessionRequest, runSessionRequest);
        int expectedHashCodeResult = runSessionRequest.hashCode();
        assertEquals(expectedHashCodeResult, runSessionRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunSessionRequest#equals(Object)}
     *   <li>{@link RunSessionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        RunSessionRequest runSessionRequest2 = new RunSessionRequest();
        assertEquals(runSessionRequest, runSessionRequest2);
        int expectedHashCodeResult = runSessionRequest.hashCode();
        assertEquals(expectedHashCodeResult, runSessionRequest2.hashCode());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        BigDecimal distance_km = new BigDecimal("2.3");
        RunSessionRequest runSessionRequest = new RunSessionRequest(distance_km, null, 1, "Notes", 1, 1, 1,
                new ArrayList<>(), 1, "Weather Conditions", null);
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setDistance_km(new BigDecimal("2.3"));
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setNotes("Notes");
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setRouteId(1);
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setShoesId(1);
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setUserId(1);
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setRoute_points(new ArrayList<>());
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setTraining_id_from_run_plan(1);
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();
        runSessionRequest.setWeatherConditions("Weather Conditions");
        assertNotEquals(runSessionRequest, new RunSessionRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunSessionRequest#equals(Object)}
     *   <li>{@link RunSessionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        BigDecimal distance_km = new BigDecimal("2.3");
        RunSessionRequest runSessionRequest = new RunSessionRequest(distance_km, null, 1, "Notes", 1, 1, 1,
                new ArrayList<>(), 1, "Weather Conditions", null);
        BigDecimal distance_km2 = new BigDecimal("2.3");
        RunSessionRequest runSessionRequest2 = new RunSessionRequest(distance_km2, null, 1, "Notes", 1, 1, 1,
                new ArrayList<>(), 1, "Weather Conditions", null);

        assertEquals(runSessionRequest, runSessionRequest2);
        int expectedHashCodeResult = runSessionRequest.hashCode();
        assertEquals(expectedHashCodeResult, runSessionRequest2.hashCode());
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals14() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();

        RunSessionRequest runSessionRequest2 = new RunSessionRequest();
        runSessionRequest2.setDistance_km(new BigDecimal("2.3"));
        assertNotEquals(runSessionRequest, runSessionRequest2);
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals15() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();

        RunSessionRequest runSessionRequest2 = new RunSessionRequest();
        runSessionRequest2.setNotes("Notes");
        assertNotEquals(runSessionRequest, runSessionRequest2);
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals16() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();

        RunSessionRequest runSessionRequest2 = new RunSessionRequest();
        runSessionRequest2.setRoute_points(new ArrayList<>());
        assertNotEquals(runSessionRequest, runSessionRequest2);
    }

    /**
     * Method under test: {@link RunSessionRequest#equals(Object)}
     */
    @Test
    void testEquals17() {
        RunSessionRequest runSessionRequest = new RunSessionRequest();

        RunSessionRequest runSessionRequest2 = new RunSessionRequest();
        runSessionRequest2.setWeatherConditions("Weather Conditions");
        assertNotEquals(runSessionRequest, runSessionRequest2);
    }
}
