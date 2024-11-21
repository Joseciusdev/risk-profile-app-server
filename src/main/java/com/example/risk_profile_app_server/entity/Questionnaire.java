package com.example.risk_profile_app_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Questionnaire {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String question;
  private String answer;
  private int score;
}
