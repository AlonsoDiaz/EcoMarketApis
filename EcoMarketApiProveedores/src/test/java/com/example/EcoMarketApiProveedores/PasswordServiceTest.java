package com.example.EcoMarketApiProveedores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EcoMarketApiProveedores.services.PasswordService;


@ExtendWith(MockitoExtension.class)
public class PasswordServiceTest {

    private final PasswordService servicio = new PasswordService();

    @Test
    void passwordSegura_valida() {
        assertThat(servicio.passwordSegura("12345678")).isTrue();
    }
    
}
