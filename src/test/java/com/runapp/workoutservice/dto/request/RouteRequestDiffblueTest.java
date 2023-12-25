package com.runapp.workoutservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RouteRequest.class})
@ExtendWith(SpringExtension.class)
class RouteRequestDiffblueTest {
    @Autowired
    private RouteRequest routeRequest;

    /**
     * Method under test: {@link RouteRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(routeRequest.canEqual("Other"));
        assertTrue(routeRequest.canEqual(routeRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#RouteRequest()}
     *   <li>{@link RouteRequest#setEndLocation(String)}
     *   <li>{@link RouteRequest#setStartLocation(String)}
     *   <li>{@link RouteRequest#setTerrainTypeId(int)}
     *   <li>{@link RouteRequest#toString()}
     *   <li>{@link RouteRequest#getEndLocation()}
     *   <li>{@link RouteRequest#getStartLocation()}
     *   <li>{@link RouteRequest#getTerrainTypeId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RouteRequest actualRouteRequest = new RouteRequest();
        actualRouteRequest.setEndLocation("End Location");
        actualRouteRequest.setStartLocation("Start Location");
        actualRouteRequest.setTerrainTypeId(1);
        String actualToStringResult = actualRouteRequest.toString();
        String actualEndLocation = actualRouteRequest.getEndLocation();
        String actualStartLocation = actualRouteRequest.getStartLocation();
        assertEquals("End Location", actualEndLocation);
        assertEquals("RouteRequest(startLocation=Start Location, endLocation=End Location, terrainTypeId=1)",
                actualToStringResult);
        assertEquals("Start Location", actualStartLocation);
        assertEquals(1, actualRouteRequest.getTerrainTypeId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#RouteRequest(String, String, int)}
     *   <li>{@link RouteRequest#setEndLocation(String)}
     *   <li>{@link RouteRequest#setStartLocation(String)}
     *   <li>{@link RouteRequest#setTerrainTypeId(int)}
     *   <li>{@link RouteRequest#toString()}
     *   <li>{@link RouteRequest#getEndLocation()}
     *   <li>{@link RouteRequest#getStartLocation()}
     *   <li>{@link RouteRequest#getTerrainTypeId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        RouteRequest actualRouteRequest = new RouteRequest("Start Location", "End Location", 1);
        actualRouteRequest.setEndLocation("End Location");
        actualRouteRequest.setStartLocation("Start Location");
        actualRouteRequest.setTerrainTypeId(1);
        String actualToStringResult = actualRouteRequest.toString();
        String actualEndLocation = actualRouteRequest.getEndLocation();
        String actualStartLocation = actualRouteRequest.getStartLocation();
        assertEquals("End Location", actualEndLocation);
        assertEquals("RouteRequest(startLocation=Start Location, endLocation=End Location, terrainTypeId=1)",
                actualToStringResult);
        assertEquals("Start Location", actualStartLocation);
        assertEquals(1, actualRouteRequest.getTerrainTypeId());
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RouteRequest("Start Location", "End Location", 1), null);
        assertNotEquals(new RouteRequest("Start Location", "End Location", 1), "Different type to RouteRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#equals(Object)}
     *   <li>{@link RouteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RouteRequest routeRequest = new RouteRequest("Start Location", "End Location", 1);
        assertEquals(routeRequest, routeRequest);
        int expectedHashCodeResult = routeRequest.hashCode();
        assertEquals(expectedHashCodeResult, routeRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#equals(Object)}
     *   <li>{@link RouteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RouteRequest routeRequest = new RouteRequest("Start Location", "End Location", 1);
        RouteRequest routeRequest2 = new RouteRequest("Start Location", "End Location", 1);

        assertEquals(routeRequest, routeRequest2);
        int expectedHashCodeResult = routeRequest.hashCode();
        assertEquals(expectedHashCodeResult, routeRequest2.hashCode());
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RouteRequest routeRequest = new RouteRequest("End Location", "End Location", 1);
        assertNotEquals(routeRequest, new RouteRequest("Start Location", "End Location", 1));
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RouteRequest routeRequest = new RouteRequest(null, "End Location", 1);
        assertNotEquals(routeRequest, new RouteRequest("Start Location", "End Location", 1));
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RouteRequest routeRequest = new RouteRequest("Start Location", "Start Location", 1);
        assertNotEquals(routeRequest, new RouteRequest("Start Location", "End Location", 1));
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RouteRequest routeRequest = new RouteRequest("Start Location", null, 1);
        assertNotEquals(routeRequest, new RouteRequest("Start Location", "End Location", 1));
    }

    /**
     * Method under test: {@link RouteRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RouteRequest routeRequest = new RouteRequest("Start Location", "End Location", 2);
        assertNotEquals(routeRequest, new RouteRequest("Start Location", "End Location", 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#equals(Object)}
     *   <li>{@link RouteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        RouteRequest routeRequest = new RouteRequest(null, "End Location", 1);
        RouteRequest routeRequest2 = new RouteRequest(null, "End Location", 1);

        assertEquals(routeRequest, routeRequest2);
        int expectedHashCodeResult = routeRequest.hashCode();
        assertEquals(expectedHashCodeResult, routeRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RouteRequest#equals(Object)}
     *   <li>{@link RouteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        RouteRequest routeRequest = new RouteRequest("Start Location", null, 1);
        RouteRequest routeRequest2 = new RouteRequest("Start Location", null, 1);

        assertEquals(routeRequest, routeRequest2);
        int expectedHashCodeResult = routeRequest.hashCode();
        assertEquals(expectedHashCodeResult, routeRequest2.hashCode());
    }
}
