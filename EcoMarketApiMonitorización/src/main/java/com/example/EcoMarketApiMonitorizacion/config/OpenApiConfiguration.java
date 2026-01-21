package com.example.EcoMarketApiMonitorizacion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
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
                .description("Monitoreo de estados del sistema")
                .contact(new Contact().name("Orcaleritos")));
    }
}
