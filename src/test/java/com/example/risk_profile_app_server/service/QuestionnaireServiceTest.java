package com.example.risk_profile_app_server.service;

import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.repository.QuestionnaireRepository;
import com.example.risk_profile_app_server.service.QuestionnaireService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class QuestionnaireServiceTest {

  private final QuestionnaireRepository repository = mock(QuestionnaireRepository.class);
  // private final QuestionnaireService service = new
  // QuestionnaireService(repository);
  private final QuestionnaireService service = new QuestionnaireService();

  @Test
  void getAllQuestionsTest() {
    Questionnaire q1 = new Questionnaire();
    q1.setId(1L);
    q1.setQuestion("How would you describe your investment knowledge?");
    q1.setAnswer("Novice");
    q1.setScore(1);

    when(repository.findAll()).thenReturn(List.of(q1));

    List<Questionnaire> result = service.getAllQuestions();

    assertEquals(1, result.size());
    assertEquals("How would you describe your investment knowledge?", result.get(0).getQuestion());
    verify(repository, times(1)).findAll();
  }
}
