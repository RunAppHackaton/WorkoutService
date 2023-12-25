package com.runapp.workoutservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.workoutservice.utill.enums.DistanceTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VdotGradeRequest.class})
@ExtendWith(SpringExtension.class)
class VdotGradeRequestDiffblueTest {
    @Autowired
    private VdotGradeRequest vdotGradeRequest;

    /**
     * Method under test: {@link VdotGradeRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(vdotGradeRequest.canEqual("Other"));
        assertTrue(vdotGradeRequest.canEqual(vdotGradeRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#VdotGradeRequest()}
     *   <li>{@link VdotGradeRequest#setDistance(DistanceTypeEnum)}
     *   <li>{@link VdotGradeRequest#setTime(String)}
     *   <li>{@link VdotGradeRequest#toString()}
     *   <li>{@link VdotGradeRequest#getDistance()}
     *   <li>{@link VdotGradeRequest#getTime()}
     * </ul>
     */
    @Test
    void testConstructor() {
        VdotGradeRequest actualVdotGradeRequest = new VdotGradeRequest();
        actualVdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        actualVdotGradeRequest.setTime("Time");
        String actualToStringResult = actualVdotGradeRequest.toString();
        DistanceTypeEnum actualDistance = actualVdotGradeRequest.getDistance();
        assertEquals("Time", actualVdotGradeRequest.getTime());
        assertEquals("VdotGradeRequest(distance=EASY_1500M, time=Time)", actualToStringResult);
        assertEquals(DistanceTypeEnum.EASY_1500M, actualDistance);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#VdotGradeRequest(DistanceTypeEnum, String)}
     *   <li>{@link VdotGradeRequest#setDistance(DistanceTypeEnum)}
     *   <li>{@link VdotGradeRequest#setTime(String)}
     *   <li>{@link VdotGradeRequest#toString()}
     *   <li>{@link VdotGradeRequest#getDistance()}
     *   <li>{@link VdotGradeRequest#getTime()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        VdotGradeRequest actualVdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time");
        actualVdotGradeRequest.setDistance(DistanceTypeEnum.EASY_1500M);
        actualVdotGradeRequest.setTime("Time");
        String actualToStringResult = actualVdotGradeRequest.toString();
        DistanceTypeEnum actualDistance = actualVdotGradeRequest.getDistance();
        assertEquals("Time", actualVdotGradeRequest.getTime());
        assertEquals("VdotGradeRequest(distance=EASY_1500M, time=Time)", actualToStringResult);
        assertEquals(DistanceTypeEnum.EASY_1500M, actualDistance);
    }

    /**
     * Method under test: {@link VdotGradeRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"), null);
        assertNotEquals(new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"), "Different type to VdotGradeRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#equals(Object)}
     *   <li>{@link VdotGradeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time");
        assertEquals(vdotGradeRequest, vdotGradeRequest);
        int expectedHashCodeResult = vdotGradeRequest.hashCode();
        assertEquals(expectedHashCodeResult, vdotGradeRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#equals(Object)}
     *   <li>{@link VdotGradeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time");
        VdotGradeRequest vdotGradeRequest2 = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time");

        assertEquals(vdotGradeRequest, vdotGradeRequest2);
        int expectedHashCodeResult = vdotGradeRequest.hashCode();
        assertEquals(expectedHashCodeResult, vdotGradeRequest2.hashCode());
    }

    /**
     * Method under test: {@link VdotGradeRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(null, "Time");
        assertNotEquals(vdotGradeRequest, new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"));
    }

    /**
     * Method under test: {@link VdotGradeRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_MILE, "Time");
        assertNotEquals(vdotGradeRequest, new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"));
    }

    /**
     * Method under test: {@link VdotGradeRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, null);
        assertNotEquals(vdotGradeRequest, new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"));
    }

    /**
     * Method under test: {@link VdotGradeRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M,
                "com.runapp.workoutservice.dto.request.VdotGradeRequest");
        assertNotEquals(vdotGradeRequest, new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, "Time"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#equals(Object)}
     *   <li>{@link VdotGradeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(null, "Time");
        VdotGradeRequest vdotGradeRequest2 = new VdotGradeRequest(null, "Time");

        assertEquals(vdotGradeRequest, vdotGradeRequest2);
        int expectedHashCodeResult = vdotGradeRequest.hashCode();
        assertEquals(expectedHashCodeResult, vdotGradeRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link VdotGradeRequest#equals(Object)}
     *   <li>{@link VdotGradeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        VdotGradeRequest vdotGradeRequest = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, null);
        VdotGradeRequest vdotGradeRequest2 = new VdotGradeRequest(DistanceTypeEnum.EASY_1500M, null);

        assertEquals(vdotGradeRequest, vdotGradeRequest2);
        int expectedHashCodeResult = vdotGradeRequest.hashCode();
        assertEquals(expectedHashCodeResult, vdotGradeRequest2.hashCode());
    }
}
