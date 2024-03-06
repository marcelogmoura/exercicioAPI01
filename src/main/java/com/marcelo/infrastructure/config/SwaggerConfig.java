package com.marcelo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("ProdutosAPI - API REST para	controle de produtos")
						.description("Exercício Spring Boot - Coti Informática 2024").version("v1.0"));
	}

}
