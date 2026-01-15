package com.example.EcoMarketApiEstadoPedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.request.ActualizarPedidos;
import com.example.EcoMarketApiEstadoPedidos.services.EstadoPedidosService;

@RequestMapping("estado-pedidos")
@RestController
public class EstadoPedidosController {

    @Autowired
    private EstadoPedidosService estadoPedidosService;

    @PostMapping("")
    public EstadoPedido actualizar(@RequestBody ActualizarPedidos request) {
        return estadoPedidosService.actualizarEstado(request);
    }
}
