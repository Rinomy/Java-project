package com.carrental.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI(@Value("${spring.application.version:undefined}") String version) {
        return new OpenAPI().info(new Info().version(version));
    }
}
