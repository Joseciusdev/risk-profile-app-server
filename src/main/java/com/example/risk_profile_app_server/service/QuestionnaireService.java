package com.example.risk_profile_app_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.repository.QuestionnaireRepository;

import java.util.List;

public class QuestionnaireService {

  @Autowired
  private QuestionnaireRepository questionnaireRepository;

  public List<Questionnaire> getAllQuestions() {
    return questionnaireRepository.findAll();
  }

  public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
    return questionnaireRepository.save(questionnaire);
  }

}
