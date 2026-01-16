package com.example.EcoMarketApiEstadoPedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.EcoMarketApiEstadoPedidos.models.entitites.EstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.request.ActualizarEstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.models.request.CrearEstadoPedido;
import com.example.EcoMarketApiEstadoPedidos.services.EstadoPedidosService;

@RequestMapping("estado-pedidos")
@RestController
public class EstadoPedidosController {

    @Autowired
    private EstadoPedidosService estadoPedidosService;

    @GetMapping("")
    public List<EstadoPedido> obtenerTodo(){
        return estadoPedidosService.obtenerTodosLosEstados();
    }

    @GetMapping("/{idEstadoPedido}")
    public EstadoPedido obtenerPorId(@PathVariable int idEstadoPedido){
        return estadoPedidosService.obtenerEstadoPorId(idEstadoPedido);
    }

    @PostMapping("")
    public EstadoPedido agregar(@Valid @RequestBody CrearEstadoPedido nuevo){
        return estadoPedidosService.agregarEstado(nuevo);
    }

    @PutMapping("")
    public EstadoPedido actualizar(@Valid @RequestBody ActualizarEstadoPedido request){
        return estadoPedidosService.actualizarEstado(request);
    }
    
    @DeleteMapping("/{idEstadoPedido}")
    public String eliminar(@PathVariable int idEstadoPedido){
        return estadoPedidosService.eliminarEstado(idEstadoPedido);
    }
}
