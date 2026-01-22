package com.example.EcoMarketApiEmpleadoInventario.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenApiConfiguration {

     @Value("${app.version}")
    private String version;


    @Bean 
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Inventario de Productos")
                .version("1.0")
                .description("Gestión de productos disponibles en EcoMarket")
                .contact(new Contact()
                    .name("EcoMarket")));
    }
}