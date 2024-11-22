package com.example.risk_profile_app_server.dto;

import lombok.Data;
import java.util.List;

@Data
public class QuestionnaireDTO {
  private Long id;
  private String question;
  private List<OptionDTO> options;
}