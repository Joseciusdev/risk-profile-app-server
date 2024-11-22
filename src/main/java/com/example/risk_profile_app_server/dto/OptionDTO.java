package com.example.risk_profile_app_server.dto;

import lombok.Data;

@Data
public class OptionDTO {
  private Long id;
  private String text;
  private int score;
}