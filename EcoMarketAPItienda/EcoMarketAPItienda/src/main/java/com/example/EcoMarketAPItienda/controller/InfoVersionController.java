package com.example.EcoMarketAPItienda.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcoMarketAPItienda.models.request.InfoVersion;

@RestController
@RequestMapping("/api/tienda/info")
public class InfoVersionController {
    
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public InfoVersion info() {
        return new InfoVersion(appName, version);
    }
}