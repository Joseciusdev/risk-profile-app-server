package com.example.risk_profile_app_server.service;

import com.example.risk_profile_app_server.dto.QuestionnaireDTO;
import com.example.risk_profile_app_server.dto.OptionDTO;
import com.example.risk_profile_app_server.entity.Option;
import com.example.risk_profile_app_server.entity.Questionnaire;
import com.example.risk_profile_app_server.repository.QuestionnaireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {

  @Autowired
  private QuestionnaireRepository questionnaireRepository;

  public List<QuestionnaireDTO> getAllQuestions() {
    return questionnaireRepository.findAll().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
    if (questionnaire.getOptions() != null) {
      questionnaire.getOptions().forEach(option -> option.setQuestionnaire(questionnaire));
    }
    return questionnaireRepository.save(questionnaire);
  }

  private QuestionnaireDTO convertToDTO(Questionnaire questionnaire) {
    QuestionnaireDTO dto = new QuestionnaireDTO();
    dto.setId(questionnaire.getId());
    dto.setQuestion(questionnaire.getQuestion());
    dto.setOptions(questionnaire.getOptions().stream()
        .map(this::convertOptionToDTO)
        .collect(Collectors.toList()));
    return dto;
  }

  private OptionDTO convertOptionToDTO(Option option) {
    OptionDTO dto = new OptionDTO();
    dto.setId(option.getId());
    dto.setText(option.getText());
    dto.setScore(option.getScore());
    return dto;
  }

  public String calculateRiskProfile(List<QuestionnaireDTO> questionnaireDTOs) {
    int totalScore = 0;
    for (QuestionnaireDTO questionnaire : questionnaireDTOs) {
      for (OptionDTO option : questionnaire.getOptions()) {
        totalScore += option.getScore();
      }
    }
    if (totalScore <= 5) {
      return "Low Risk";
    } else if (totalScore <= 15) {
      return "Moderate Risk";
    } else {
      return "High Risk";
    }
  }

}
