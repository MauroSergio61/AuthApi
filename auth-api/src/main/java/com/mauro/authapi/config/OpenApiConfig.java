package com.mauro.authapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Auth API",
                version = "1.0",
                description = "API de autenticação com Spring Security + JWT"
        )
)
public class OpenApiConfig {
}
