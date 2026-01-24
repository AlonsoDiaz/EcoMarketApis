package com.example.EcoMarketApiUsuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient permisoWebClient(){
        return WebClient.builder().baseUrl("http://apipermisos.us-east-1.elasticbeanstalk.com/permiso").build();
    }
    
    
}