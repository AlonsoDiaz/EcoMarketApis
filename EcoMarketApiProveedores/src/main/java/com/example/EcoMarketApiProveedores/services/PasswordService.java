package com.example.EcoMarketApiProveedores.services;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public boolean passwordSegura(String password) {
        return password != null && password.length() >= 8;
    }
    
}
