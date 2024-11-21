package com.example.risk_profile_app_server.controller;

import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.service.QuestionnaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {

  @Autowired
  private QuestionnaireService questionnaireService;

  @GetMapping()
  public List<Questionnaire> getAllQuestions() {
    return questionnaireService.getAllQuestions();
  }

  @PostMapping()
  public Questionnaire saveQuestionnaire(@RequestBody Questionnaire questionnaire) {
    return questionnaireService.saveQuestionnaire(questionnaire);
  }
}
