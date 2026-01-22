package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI documentacionOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio Devoluciones y Reclamaciones")
                        .version("1.0")
                        .description("Gestión de devoluciones y reclamaciones"));
    }
}