package com.runapp.workoutservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AchievementResponseDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AchievementResponse}
     *   <li>{@link AchievementResponse#setAchievementImageUrl(String)}
     *   <li>{@link AchievementResponse#setDescription(String)}
     *   <li>{@link AchievementResponse#setId(int)}
     *   <li>{@link AchievementResponse#setName(String)}
     *   <li>{@link AchievementResponse#setRarityModel(RarityResponse)}
     *   <li>{@link AchievementResponse#setStory_id(int)}
     *   <li>{@link AchievementResponse#toString()}
     *   <li>{@link AchievementResponse#getAchievementImageUrl()}
     *   <li>{@link AchievementResponse#getDescription()}
     *   <li>{@link AchievementResponse#getId()}
     *   <li>{@link AchievementResponse#getName()}
     *   <li>{@link AchievementResponse#getRarityModel()}
     *   <li>{@link AchievementResponse#getStory_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AchievementResponse actualAchievementResponse = new AchievementResponse();
        actualAchievementResponse.setAchievementImageUrl("https://example.org/example");
        actualAchievementResponse.setDescription("The characteristics of someone or something");
        actualAchievementResponse.setId(1);
        actualAchievementResponse.setName("Name");
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");
        actualAchievementResponse.setRarityModel(rarityModel);
        actualAchievementResponse.setStory_id(1);
        String actualToStringResult = actualAchievementResponse.toString();
        String actualAchievementImageUrl = actualAchievementResponse.getAchievementImageUrl();
        String actualDescription = actualAchievementResponse.getDescription();
        int actualId = actualAchievementResponse.getId();
        String actualName = actualAchievementResponse.getName();
        RarityResponse actualRarityModel = actualAchievementResponse.getRarityModel();
        assertEquals(
                "AchievementResponse(id=1, name=Name, story_id=1, description=The characteristics of someone or something,"
                        + " achievementImageUrl=https://example.org/example, rarityModel=RarityResponse(id=1, name=Name))",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualAchievementImageUrl);
        assertEquals(1, actualId);
        assertEquals(1, actualAchievementResponse.getStory_id());
        assertSame(rarityModel, actualRarityModel);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);
        assertNotEquals(achievementResponse, null);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals2() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);
        assertNotEquals(achievementResponse, "Different type to AchievementResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementResponse#equals(Object)}
     *   <li>{@link AchievementResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);
        assertEquals(achievementResponse, achievementResponse);
        int expectedHashCodeResult = achievementResponse.hashCode();
        assertEquals(expectedHashCodeResult, achievementResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AchievementResponse#equals(Object)}
     *   <li>{@link AchievementResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertEquals(achievementResponse, achievementResponse2);
        int expectedHashCodeResult = achievementResponse.hashCode();
        assertEquals(expectedHashCodeResult, achievementResponse2.hashCode());
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("Name");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl(null);
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("Name");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription(null);
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(2);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("The characteristics of someone or something");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        RarityResponse rarityModel = new RarityResponse();
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName(null);
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        RarityResponse rarityModel = mock(RarityResponse.class);
        doNothing().when(rarityModel).setId(anyInt());
        doNothing().when(rarityModel).setName(Mockito.<String>any());
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(1);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }

    /**
     * Method under test: {@link AchievementResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        RarityResponse rarityModel = mock(RarityResponse.class);
        doNothing().when(rarityModel).setId(anyInt());
        doNothing().when(rarityModel).setName(Mockito.<String>any());
        rarityModel.setId(1);
        rarityModel.setName("Name");

        AchievementResponse achievementResponse = new AchievementResponse();
        achievementResponse.setAchievementImageUrl("https://example.org/example");
        achievementResponse.setDescription("The characteristics of someone or something");
        achievementResponse.setId(1);
        achievementResponse.setName("Name");
        achievementResponse.setRarityModel(rarityModel);
        achievementResponse.setStory_id(2);

        RarityResponse rarityModel2 = new RarityResponse();
        rarityModel2.setId(1);
        rarityModel2.setName("Name");

        AchievementResponse achievementResponse2 = new AchievementResponse();
        achievementResponse2.setAchievementImageUrl("https://example.org/example");
        achievementResponse2.setDescription("The characteristics of someone or something");
        achievementResponse2.setId(1);
        achievementResponse2.setName("Name");
        achievementResponse2.setRarityModel(rarityModel2);
        achievementResponse2.setStory_id(1);
        assertNotEquals(achievementResponse, achievementResponse2);
    }
}
