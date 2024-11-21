package com.example.risk_profile_app_server.controller;

import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.service.QuestionnaireService;
import com.example.risk_profile_app_server.controller.QuestionnaireController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class QuestionnaireControllerTest {

  private final QuestionnaireService service = mock(QuestionnaireService.class);
  private final QuestionnaireController controller = new QuestionnaireController();
  // private final QuestionnaireController controller = new
  // QuestionnaireController(service);

  private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

  @Test
  void getAllQuestionsTest() throws Exception {
    Questionnaire q1 = new Questionnaire();
    q1.setId(1L);
    q1.setQuestion("How would you describe your investment knowledge?");
    q1.setAnswer("Novice");
    q1.setScore(1);

    when(service.getAllQuestions()).thenReturn(List.of(q1));

    mockMvc.perform(get("/api/questionnaire").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].question").value("How would you describe your investment knowledge?"));
  }
}
