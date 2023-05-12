package com.example.edecision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "E-Decision Projets API", version = "1.0", description = "Microservice projets E-Decision"))
public class EDecisionProjetsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EDecisionProjetsApiApplication.class, args);
	}

}
