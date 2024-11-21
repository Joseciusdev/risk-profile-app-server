package com.example.risk_profile_app_server.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:19000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
      }
    };
  }

  // @Bean
  // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
  // Exception {
  // return http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
  // .csrf(AbstractHttpConfigurer::disable)
  // .authorizeHttpRequests((auth) -> {
  // auth.requestMatchers("/api/questionnaire",
  // "/api/public").permitAll();
  // auth.anyRequest().authenticated();
  // }).build();
  // }

  // @Bean
  // CorsConfigurationSource corsConfigurationSource() {
  // CorsConfiguration configuration = new CorsConfiguration();
  // configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
  // configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
  // "DELETE"));
  // configuration.setAllowedHeaders(Arrays.asList("*"));
  // UrlBasedCorsConfigurationSource source = new
  // UrlBasedCorsConfigurationSource();
  // source.registerCorsConfiguration("/**", configuration);
  // return source;
  // }
}
