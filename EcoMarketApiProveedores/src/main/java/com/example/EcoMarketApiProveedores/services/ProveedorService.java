package com.example.EcoMarketApiProveedores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiProveedores.models.entities.Proveedor;
import com.example.EcoMarketApiProveedores.models.request.ActualizarProveedor;
import com.example.EcoMarketApiProveedores.models.request.AgregarProveedor;
import com.example.EcoMarketApiProveedores.repositories.ProveedorRepository;

@Service
public class ProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;

	public List<Proveedor> obtenerTodos() {
		return proveedorRepository.findAll();
	}

	public Proveedor obtenerPorId(int proveedorId) {
		return proveedorRepository.findById(proveedorId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado."));
	}

	public Proveedor agregarProveedor(AgregarProveedor nuevo) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nuevo.getNombre());
		proveedor.setContacto(nuevo.getContacto());
		proveedor.setTelefono(nuevo.getTelefono());
		proveedor.setEmail(nuevo.getEmail());
		proveedor.setDireccion(nuevo.getDireccion());
		proveedor.setMinimoPedido(nuevo.getMinimoPedido());
		proveedor.setCondiciones(nuevo.getCondiciones());
		proveedor.setNotasRecepcion(nuevo.getNotasRecepcion());
		proveedor.setActivo(Boolean.TRUE.equals(nuevo.getActivo()));
		return proveedorRepository.save(proveedor);
	}

	public Proveedor actualizarProveedor(ActualizarProveedor actualizar) {
		Proveedor proveedor = proveedorRepository.findById(actualizar.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado."));

		proveedor.setNombre(actualizar.getNombre());
		proveedor.setContacto(actualizar.getContacto());
		proveedor.setTelefono(actualizar.getTelefono());
		proveedor.setEmail(actualizar.getEmail());
		proveedor.setDireccion(actualizar.getDireccion());
		proveedor.setMinimoPedido(actualizar.getMinimoPedido());
		proveedor.setCondiciones(actualizar.getCondiciones());
		proveedor.setNotasRecepcion(actualizar.getNotasRecepcion());
		proveedor.setActivo(Boolean.TRUE.equals(actualizar.getActivo()));
		return proveedorRepository.save(proveedor);
	}

	public String eliminarProveedor(int proveedorId) {
		if (!proveedorRepository.existsById(proveedorId)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado.");
		}
		proveedorRepository.deleteById(proveedorId);
		return "Proveedor eliminado.";
	}
}
