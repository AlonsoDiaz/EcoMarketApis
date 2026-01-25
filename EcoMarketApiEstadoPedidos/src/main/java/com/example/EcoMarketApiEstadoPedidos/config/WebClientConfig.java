package com.example.EcoMarketApiEstadoPedidos.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @Qualifier("enviosWebClient")
    public WebClient enviosWebClient() {
        return WebClient.builder().baseUrl("http://apienvios.us-west-2.elasticbeanstalk.com/envio").build();
    }

    @Bean
    @Qualifier("pedidosWebClient")
    public WebClient pedidosWebClient() {
        return WebClient.builder().baseUrl("http://pedido.us-east-1.elasticbeanstalk.com/pedidos").build();
    }
}
