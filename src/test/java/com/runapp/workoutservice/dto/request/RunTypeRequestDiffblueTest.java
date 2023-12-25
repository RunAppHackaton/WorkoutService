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

@ContextConfiguration(classes = {RunTypeRequest.class})
@ExtendWith(SpringExtension.class)
class RunTypeRequestDiffblueTest {
    @Autowired
    private RunTypeRequest runTypeRequest;

    /**
     * Method under test: {@link RunTypeRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(runTypeRequest.canEqual("Other"));
        assertTrue(runTypeRequest.canEqual(runTypeRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#RunTypeRequest()}
     *   <li>{@link RunTypeRequest#setDescription(String)}
     *   <li>{@link RunTypeRequest#setIntervals(int)}
     *   <li>{@link RunTypeRequest#setType_name(String)}
     *   <li>{@link RunTypeRequest#toString()}
     *   <li>{@link RunTypeRequest#getDescription()}
     *   <li>{@link RunTypeRequest#getIntervals()}
     *   <li>{@link RunTypeRequest#getType_name()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RunTypeRequest actualRunTypeRequest = new RunTypeRequest();
        actualRunTypeRequest.setDescription("The characteristics of someone or something");
        actualRunTypeRequest.setIntervals(42);
        actualRunTypeRequest.setType_name("Type name");
        String actualToStringResult = actualRunTypeRequest.toString();
        String actualDescription = actualRunTypeRequest.getDescription();
        int actualIntervals = actualRunTypeRequest.getIntervals();
        assertEquals("RunTypeRequest(type_name=Type name, description=The characteristics of someone or something,"
                + " intervals=42)", actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Type name", actualRunTypeRequest.getType_name());
        assertEquals(42, actualIntervals);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#RunTypeRequest(String, String, int)}
     *   <li>{@link RunTypeRequest#setDescription(String)}
     *   <li>{@link RunTypeRequest#setIntervals(int)}
     *   <li>{@link RunTypeRequest#setType_name(String)}
     *   <li>{@link RunTypeRequest#toString()}
     *   <li>{@link RunTypeRequest#getDescription()}
     *   <li>{@link RunTypeRequest#getIntervals()}
     *   <li>{@link RunTypeRequest#getType_name()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        RunTypeRequest actualRunTypeRequest = new RunTypeRequest("Type name", "The characteristics of someone or something",
                42);
        actualRunTypeRequest.setDescription("The characteristics of someone or something");
        actualRunTypeRequest.setIntervals(42);
        actualRunTypeRequest.setType_name("Type name");
        String actualToStringResult = actualRunTypeRequest.toString();
        String actualDescription = actualRunTypeRequest.getDescription();
        int actualIntervals = actualRunTypeRequest.getIntervals();
        assertEquals("RunTypeRequest(type_name=Type name, description=The characteristics of someone or something,"
                + " intervals=42)", actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Type name", actualRunTypeRequest.getType_name());
        assertEquals(42, actualIntervals);
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RunTypeRequest("Type name", "The characteristics of someone or something", 42), null);
        assertNotEquals(new RunTypeRequest("Type name", "The characteristics of someone or something", 42),
                "Different type to RunTypeRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#equals(Object)}
     *   <li>{@link RunTypeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", "The characteristics of someone or something", 42);
        assertEquals(runTypeRequest, runTypeRequest);
        int expectedHashCodeResult = runTypeRequest.hashCode();
        assertEquals(expectedHashCodeResult, runTypeRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#equals(Object)}
     *   <li>{@link RunTypeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", "The characteristics of someone or something", 42);
        RunTypeRequest runTypeRequest2 = new RunTypeRequest("Type name", "The characteristics of someone or something", 42);

        assertEquals(runTypeRequest, runTypeRequest2);
        int expectedHashCodeResult = runTypeRequest.hashCode();
        assertEquals(expectedHashCodeResult, runTypeRequest2.hashCode());
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("The characteristics of someone or something",
                "The characteristics of someone or something", 42);
        assertNotEquals(runTypeRequest, new RunTypeRequest("Type name", "The characteristics of someone or something", 42));
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RunTypeRequest runTypeRequest = new RunTypeRequest(null, "The characteristics of someone or something", 42);
        assertNotEquals(runTypeRequest, new RunTypeRequest("Type name", "The characteristics of someone or something", 42));
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", "Type name", 42);
        assertNotEquals(runTypeRequest, new RunTypeRequest("Type name", "The characteristics of someone or something", 42));
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", null, 42);
        assertNotEquals(runTypeRequest, new RunTypeRequest("Type name", "The characteristics of someone or something", 42));
    }

    /**
     * Method under test: {@link RunTypeRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", "The characteristics of someone or something", 1);
        assertNotEquals(runTypeRequest, new RunTypeRequest("Type name", "The characteristics of someone or something", 42));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#equals(Object)}
     *   <li>{@link RunTypeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        RunTypeRequest runTypeRequest = new RunTypeRequest(null, "The characteristics of someone or something", 42);
        RunTypeRequest runTypeRequest2 = new RunTypeRequest(null, "The characteristics of someone or something", 42);

        assertEquals(runTypeRequest, runTypeRequest2);
        int expectedHashCodeResult = runTypeRequest.hashCode();
        assertEquals(expectedHashCodeResult, runTypeRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RunTypeRequest#equals(Object)}
     *   <li>{@link RunTypeRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        RunTypeRequest runTypeRequest = new RunTypeRequest("Type name", null, 42);
        RunTypeRequest runTypeRequest2 = new RunTypeRequest("Type name", null, 42);

        assertEquals(runTypeRequest, runTypeRequest2);
        int expectedHashCodeResult = runTypeRequest.hashCode();
        assertEquals(expectedHashCodeResult, runTypeRequest2.hashCode());
    }
}
