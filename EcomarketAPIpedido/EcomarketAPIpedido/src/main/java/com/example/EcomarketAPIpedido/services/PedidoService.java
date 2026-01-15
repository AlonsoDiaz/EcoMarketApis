package com.example.EcomarketAPIpedido.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcomarketAPIpedido.models.entities.Pedido;
import com.example.EcomarketAPIpedido.models.request.ActualizarPedido;
import com.example.EcomarketAPIpedido.models.request.AgregarPedido;
import com.example.EcomarketAPIpedido.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido guardarPedido(AgregarPedido request) {
        Pedido pedido = new Pedido();
        pedido.setCliente(request.getCliente());
        pedido.setEstado(request.getEstado());
        pedido.setTienda(request.getTienda());
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarPedido(ActualizarPedido request) {
        return pedidoRepository.findById(request.getId_pedido()).map(pedido -> {
            pedido.setCliente(request.getCliente());
            pedido.setEstado(request.getEstado());
            pedido.setTienda(request.getTienda());
            return pedidoRepository.save(pedido);
        }).orElse(null);
    }

    public String cancelarPedido(int id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return "Pedido eliminado";
        }
        return "No encontrado";
    }
}