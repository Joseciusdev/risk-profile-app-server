package com.example.risk_profile_app_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Option {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String text;
  private int score;

  @ManyToOne
  @JoinColumn(name = "questionnaire_id")
  private Questionnaire questionnaire;
}
