package com.example.EcomarketAPIpedido.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcomarketAPIpedido.models.request.InfoVersion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping()
@RestController
public class InfoVersionController {


    @Value("${app.name}")
    private String appName;
    
    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public InfoVersion info(){
        return new InfoVersion(appName,version);
    }
    
    
    
}
