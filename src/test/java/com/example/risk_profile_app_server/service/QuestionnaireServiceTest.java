package com.example.risk_profile_app_server.service;

import com.example.risk_profile_app_server.dto.OptionDTO;
import com.example.risk_profile_app_server.dto.QuestionnaireDTO;
import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.repository.QuestionnaireRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class QuestionnaireServiceTest {

  @Mock
  private QuestionnaireRepository questionnaireRepository;

  @InjectMocks
  private QuestionnaireService questionnaireService;

  public QuestionnaireServiceTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetAllQuestions() {
    List<Questionnaire> mockEntities = Arrays.asList(
        new Questionnaire(1L, "Question 1", null),
        new Questionnaire(2L, "Question 2", null));

    when(questionnaireRepository.findAll()).thenReturn(mockEntities);

    List<QuestionnaireDTO> result = questionnaireService.getAllQuestions();
    assertEquals(2, result.size());
    assertEquals("Question 1", result.get(0).getQuestion());
  }

  @Test
  void testCalculateRiskProfile() {
    List<OptionDTO> options = Arrays.asList(
        new OptionDTO(1L, "Option 1", 3),
        new OptionDTO(2L, "Option 2", 4));

    List<QuestionnaireDTO> questionnaireDTOs = Arrays.asList(
        new QuestionnaireDTO(1L, "Question 1", options));

    String result = questionnaireService.calculateRiskProfile(questionnaireDTOs);
    assertEquals("Moderate Risk", result);
  }
}
