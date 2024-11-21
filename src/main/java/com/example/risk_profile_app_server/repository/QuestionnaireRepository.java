package com.example.risk_profile_app_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.risk_profile_app_server.entity.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}