package com.example.webapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("xxxAPI")
                        .description("xxx Restfull API")
                        .version("v0.0.1")
                        .license(new License().name("xxx")))
                .externalDocs(new ExternalDocumentation()
                        .description("xxx Issues Documentation")
                        .url("https://****"));
    }
}
