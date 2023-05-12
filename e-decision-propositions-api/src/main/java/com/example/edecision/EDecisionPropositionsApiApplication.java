package com.example.edecision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "E-Decision propositions API", version = "1.0", description = "Microservice propositions E-Decision"))
public class EDecisionPropositionsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EDecisionPropositionsApiApplication.class, args);
	}

}
