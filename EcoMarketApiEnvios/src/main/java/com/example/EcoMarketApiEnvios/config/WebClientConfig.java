package com.example.EcoMarketApiEnvios.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient tiendaWebClient(){
         return WebClient.builder().baseUrl("http://tienda.us-east-1.elasticbeanstalk.com/tiendas").build();
    }
}
