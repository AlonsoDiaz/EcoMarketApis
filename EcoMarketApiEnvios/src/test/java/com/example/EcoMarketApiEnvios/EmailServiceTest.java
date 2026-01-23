package com.example.EcoMarketApiEnvios;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiEnvios.services.EmailService;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    private final EmailService service = new EmailService();

    @Test
    void emailValido_correcto() {
        assertThat(service.emailValido("correo@test.cl")).isTrue();
}

    
}
