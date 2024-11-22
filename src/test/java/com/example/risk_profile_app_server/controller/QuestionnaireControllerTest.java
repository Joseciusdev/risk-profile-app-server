package com.example.risk_profile_app_server.controller;

import com.example.risk_profile_app_server.dto.QuestionnaireDTO;
import com.example.risk_profile_app_server.dto.ResultDTO;
import com.example.risk_profile_app_server.service.QuestionnaireService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuestionnaireController.class)
class QuestionnaireControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private QuestionnaireService questionnaireService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testGetAllQuestions() throws Exception {
    List<QuestionnaireDTO> mockQuestions = Arrays.asList(
        new QuestionnaireDTO(1L, "Question 1", null),
        new QuestionnaireDTO(2L, "Question 2", null));

    when(questionnaireService.getAllQuestions()).thenReturn(mockQuestions);

    mockMvc.perform(get("/api/questionnaire"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[1].id").value(2));
  }

  @Test
  void testSubmitAnswers() throws Exception {
    List<QuestionnaireDTO> mockRequest = Arrays.asList(
        new QuestionnaireDTO(1L, "Question 1", null),
        new QuestionnaireDTO(2L, "Question 2", null));

    String riskProfile = "Moderate Risk";
    when(questionnaireService.calculateRiskProfile(Mockito.anyList())).thenReturn(riskProfile);

    mockMvc.perform(post("/api/questionnaire/submit")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(mockRequest)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.riskProfile").value(riskProfile));
  }
}
