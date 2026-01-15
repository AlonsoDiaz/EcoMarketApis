package com.example.EcomarketAPIpedido.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.EcomarketAPIpedido.models.request.AgregarPedido;
import com.example.EcomarketAPIpedido.models.entities.Pedido;
import com.example.EcomarketAPIpedido.models.request.ActualizarPedido;
import com.example.EcomarketAPIpedido.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodos() {

        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPorId(@PathVariable int id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody AgregarPedido nuevoPedido) {
        return pedidoService.guardarPedido(nuevoPedido);
    }

    @PutMapping
    public Pedido actualizarPedido(@Valid @RequestBody ActualizarPedido datos) {
        return pedidoService.actualizarPedido(datos);
    }

    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable int id) {
        return pedidoService.cancelarPedido(id);
    }
}