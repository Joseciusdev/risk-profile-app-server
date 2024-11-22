package com.example.risk_profile_app_server.dto;

import lombok.Data;

@Data
public class ResultDTO {
  private String riskProfile;

  public ResultDTO(String riskProfile) {
    this.riskProfile = riskProfile;
  }
}
