package com.example.EcoMarketApiEmpleadoDevolucionesReclamaciones.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Bean
    public OpenAPI documentacionOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(appName)
                        .version(appVersion) 
                        .description("Microservicio para empleados"));
    }
}