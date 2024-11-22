# How it works

# Backend:

GET /api/questionnaire: Fetches the list of questions.
POST /api/questionnaire: Adds a new question.
POST /api/questionnaire/submit: Submits answers and returns the user's risk profile.
Business Logic: Calculates the risk profile based on the total score from the answers.

# Frontend:

Users answer questions one by one.
Answers are submitted to the backend.
The risk profile (e.g., Low, Moderate, High) is displayed on the result screen.

# Project Structure 

backend/
├── src/main/java/com/example/risk_profile_app_server/
│   ├── controller/        # REST API controllers
│   ├── dto/               # Data Transfer Objects
│   ├── entity/            # Entity classes
│   ├── repository/        # Repository interfaces
│   ├── service/           # Business logic
├── src/test/java/         # Unit tests
├── resources/
│   ├── application.properties  # Application configuration
└── pom.xml                # Maven dependencies


# How to Run the Application:

  # Prerequisites: 
  
  Backend (Spring Boot):
  Java JDK 17 or higher.
  Maven 3.6+.
  PostgreSQL or H2 Database (optional, for production use).

# 1) Clone the repository :

git clone repository-url

cd projectName

# 2) Open application.properties and configure the database (e.g., H2 or PostgreSQL):

spring.application.name=risk-profile-app-server

# Database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/risk_profile_2
spring.datasource.username=postgres
spring.datasource.password=admin12

# JPA configuration
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.time_zone=UTC

# Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Server Port
server.port=8080

# Build and run the application:
mvn clean install
mvn spring-boot:run

# Access the API:
Base URL: http://localhost:8080/api/questionnaire (as you desired)
Swagger UI (if enabled): http://localhost:8080/swagger-ui.html

# Running Tests
mvn test

# Key test files

src/test/java/com/example/risk_profile_app_server/controller/QuestionnaireControllerTest.java
src/test/java/com/example/risk_profile_app_server/service/QuestionnaireServiceTest.java





