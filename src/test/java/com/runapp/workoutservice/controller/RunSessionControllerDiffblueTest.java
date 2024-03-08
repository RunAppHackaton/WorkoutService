package com.runapp.workoutservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.workoutservice.dtoMapper.RunSessionDtoMapper;
import com.runapp.workoutservice.dto.request.RunSessionRequest;
import com.runapp.workoutservice.dto.response.RunSessionResponse;
import com.runapp.workoutservice.model.RunSessionModel;
import com.runapp.workoutservice.model.TrainingModel;
import com.runapp.workoutservice.service.serviceTemplate.RunSessionService;
import com.runapp.workoutservice.staticObject.StaticRunSession;
import com.runapp.workoutservice.staticObject.StaticTraining;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RunSessionController.class})
@ExtendWith(SpringExtension.class)
class RunSessionControllerDiffblueTest {
    @Autowired
    private RunSessionController runSessionController;

    @MockBean
    private RunSessionDtoMapper runSessionDtoMapper;

    @MockBean
    private RunSessionService runSessionService;

    /**
     * Method under test:
     * {@link RunSessionController#addRunSession(RunSessionRequest)}
     */
    @Test
    void testAddRunSession() throws Exception {
        when(runSessionService.getAll()).thenReturn(new ArrayList<>());

        RunSessionRequest runSessionRequest = StaticRunSession.runSessionRequest1();
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link RunSessionController#addRunSession(RunSessionRequest)}
     */
    @Test
    void testAddRunSession2() throws Exception {
        RunSessionModel runSessionModel = StaticRunSession.runSession();

        ArrayList<RunSessionModel> runSessionModelList = new ArrayList<>();
        runSessionModelList.add(runSessionModel);
        when(runSessionService.getAll()).thenReturn(runSessionModelList);

        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = StaticRunSession.runSessionResponseBuilder();

        TrainingModel training2 = StaticTraining.trainingModel1();
        RunSessionResponse buildResult = shoesIdResult.training(training2)
                .userId("1")
                .weatherConditions("Weather Conditions")
                .build();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);

        RunSessionRequest runSessionRequest = StaticRunSession.runSessionRequest1();
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "[{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,"
//                                        + "\"weatherConditions\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\","
//                                        + "\"route\":{\"id\":1,\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,"
//                                        + "\"stage\":{\"id\":1,\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or"
//                                        + " something\"},\"runType\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or"
//                                        + " something\",\"runtypeImageUrl\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId"
//                                        + "\":1}]"));
    }

    /**
     * Method under test: {@link RunSessionController#deleteRunSession(Long)}
     */
    @Test
    void testDeleteRunSession() throws Exception {
        doNothing().when(runSessionService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-sessions/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunSessionController#deleteRunSession(Long)}
     */
    @Test
    void testDeleteRunSession2() throws Exception {
        doNothing().when(runSessionService).deleteById(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/run-sessions/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RunSessionController#getAllRunSessions()}
     */
    @Test
    void testGetAllRunSessions() throws Exception {
        when(runSessionService.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions");
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RunSessionController#getAllRunSessions()}
     */
    @Test
    void testGetAllRunSessions2() throws Exception {
        RunSessionModel runSessionModel = StaticRunSession.runSession();

        ArrayList<RunSessionModel> runSessionModelList = new ArrayList<>();
        runSessionModelList.add(runSessionModel);
        when(runSessionService.getAll()).thenReturn(runSessionModelList);

        RunSessionResponse.RunSessionResponseBuilder shoesIdResult = StaticRunSession.runSessionResponseBuilder();

        RunSessionResponse buildResult = StaticRunSession.runSessionResponse1();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions");
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "[{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"caloriesBurned\":1,"
//                                        + "\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\","
//                                        + "\"route\":{\"id\":1,\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,"
//                                        + "\"stage\":{\"id\":1,\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or"
//                                        + " something\"},\"runType\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or"
//                                        + " something\",\"runtypeImageUrl\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId"
//                                        + "\":1}]"));
    }

    /**
     * Method under test: {@link RunSessionController#getRunSessionById(Long)}
     */
    @Test
    void testGetRunSessionById() throws Exception {
        RunSessionModel runSessionModel = StaticRunSession.runSession();
        when(runSessionService.getById(Mockito.<Long>any())).thenReturn(runSessionModel);
        RunSessionResponse buildResult = StaticRunSession.runSessionResponse1();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/run-sessions/{id}", 1L);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,\"weatherConditions"
//                                        + "\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\",\"route\":{\"id\":1,"
//                                        + "\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,\"stage\":{\"id\":1,"
//                                        + "\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or something\"},\"runType"
//                                        + "\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or something\",\"runtypeImageUrl"
//                                        + "\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId\":1}"));
    }

    /**
     * Method under test:
     * {@link RunSessionController#updateRunSession(Long, RunSessionRequest)}
     */
    @Test
    void testUpdateRunSession() throws Exception {
        RunSessionModel runSessionModel = StaticRunSession.runSession();
        RunSessionModel runSessionModel2 = StaticRunSession.runSession();

        runSessionModel2.setWeatherConditions("Weather Conditions");
        when(runSessionService.update(Mockito.<RunSessionModel>any())).thenReturn(runSessionModel2);
        when(runSessionService.getById(Mockito.<Long>any())).thenReturn(runSessionModel);

        RunSessionModel runSessionModel3 = StaticRunSession.runSession();

        RunSessionResponse buildResult = StaticRunSession.runSessionResponse1();
        when(runSessionDtoMapper.toResponse(Mockito.<RunSessionModel>any())).thenReturn(buildResult);
        when(runSessionDtoMapper.toModel(Mockito.<RunSessionRequest>any())).thenReturn(runSessionModel3);

        RunSessionRequest runSessionRequest = StaticRunSession.runSessionRequest1();
        String content = (new ObjectMapper()).writeValueAsString(runSessionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/run-sessions/{id}", 1L).header("X-UserId", "123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(runSessionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"id\":1,\"date\":[1970,1,1],\"distance\":1,\"duration_time\":null,\"pace\":null,\"caloriesBurned\":1,\"weatherConditions"
//                                        + "\":\"Weather Conditions\",\"notes\":\"Notes\",\"photosUrl\":\"https://example.org/example\",\"route\":{\"id\":1,"
//                                        + "\"routePoints\":[]},\"training\":{\"id\":1,\"kilometers\":10.0,\"warmUp\":10.0,\"hitch\":10.0,\"stage\":{\"id\":1,"
//                                        + "\"stageEnum\":\"STAGE1\",\"name\":\"Name\",\"description\":\"The characteristics of someone or something\"},\"runType"
//                                        + "\":{\"id\":1,\"typeName\":\"EASY_RUN\",\"description\":\"The characteristics of someone or something\",\"runtypeImageUrl"
//                                        + "\":\"https://example.org/example\"},\"intervalModelList\":[]},\"userId\":1,\"shoesId\":1}"));
    }
}
