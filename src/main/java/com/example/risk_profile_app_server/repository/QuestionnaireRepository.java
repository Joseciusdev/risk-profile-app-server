package com.example.risk_profile_app_server.repository;

import com.example.risk_profile_app_server.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}