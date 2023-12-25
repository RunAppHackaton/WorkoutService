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

@ContextConfiguration(classes = {RoutePointRequest.class})
@ExtendWith(SpringExtension.class)
class RoutePointRequestDiffblueTest {
    @Autowired
    private RoutePointRequest routePointRequest;

    /**
     * Method under test: {@link RoutePointRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(routePointRequest.canEqual("Other"));
        assertTrue(routePointRequest.canEqual(routePointRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoutePointRequest#RoutePointRequest()}
     *   <li>{@link RoutePointRequest#setLatitude(double)}
     *   <li>{@link RoutePointRequest#setLongitude(double)}
     *   <li>{@link RoutePointRequest#toString()}
     *   <li>{@link RoutePointRequest#getLatitude()}
     *   <li>{@link RoutePointRequest#getLongitude()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RoutePointRequest actualRoutePointRequest = new RoutePointRequest();
        actualRoutePointRequest.setLatitude(10.0d);
        actualRoutePointRequest.setLongitude(10.0d);
        String actualToStringResult = actualRoutePointRequest.toString();
        double actualLatitude = actualRoutePointRequest.getLatitude();
        assertEquals("RoutePointRequest(latitude=10.0, longitude=10.0)", actualToStringResult);
        assertEquals(10.0d, actualLatitude);
        assertEquals(10.0d, actualRoutePointRequest.getLongitude());
    }

    /**
     * Method under test:
     * {@link RoutePointRequest#RoutePointRequest(double, double)}
     */
    @Test
    void testConstructor2() {
        RoutePointRequest actualRoutePointRequest = new RoutePointRequest(10.0d, 10.0d);

        assertEquals(10.0d, actualRoutePointRequest.getLatitude());
        assertEquals(10.0d, actualRoutePointRequest.getLongitude());
    }

    /**
     * Method under test: {@link RoutePointRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RoutePointRequest(10.0d, 10.0d), null);
        assertNotEquals(new RoutePointRequest(10.0d, 10.0d), "Different type to RoutePointRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoutePointRequest#equals(Object)}
     *   <li>{@link RoutePointRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RoutePointRequest routePointRequest = new RoutePointRequest(10.0d, 10.0d);
        assertEquals(routePointRequest, routePointRequest);
        int expectedHashCodeResult = routePointRequest.hashCode();
        assertEquals(expectedHashCodeResult, routePointRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RoutePointRequest#equals(Object)}
     *   <li>{@link RoutePointRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RoutePointRequest routePointRequest = new RoutePointRequest(10.0d, 10.0d);
        RoutePointRequest routePointRequest2 = new RoutePointRequest(10.0d, 10.0d);

        assertEquals(routePointRequest, routePointRequest2);
        int expectedHashCodeResult = routePointRequest.hashCode();
        assertEquals(expectedHashCodeResult, routePointRequest2.hashCode());
    }

    /**
     * Method under test: {@link RoutePointRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RoutePointRequest routePointRequest = new RoutePointRequest(0.5d, 10.0d);
        assertNotEquals(routePointRequest, new RoutePointRequest(10.0d, 10.0d));
    }

    /**
     * Method under test: {@link RoutePointRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RoutePointRequest routePointRequest = new RoutePointRequest(10.0d, 0.5d);
        assertNotEquals(routePointRequest, new RoutePointRequest(10.0d, 10.0d));
    }
}
