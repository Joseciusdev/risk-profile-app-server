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






