package com.example.EcoMarketApiProveedores.controller;

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

import com.example.EcoMarketApiProveedores.models.entities.Proveedor;
import com.example.EcoMarketApiProveedores.models.request.ActualizarProveedor;
import com.example.EcoMarketApiProveedores.models.request.AgregarProveedor;
import com.example.EcoMarketApiProveedores.services.ProveedorService;

@RequestMapping("proveedor")
@RestController
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("")
	public List<Proveedor> obtenerTodo() {
		return proveedorService.obtenerTodos();
	}

	@GetMapping("/{idProveedor}")
	public Proveedor obtenerPorId(@PathVariable int idProveedor) {
		return proveedorService.obtenerPorId(idProveedor);
	}

	@PostMapping("")
	public Proveedor agregarProveedor(@RequestBody AgregarProveedor nuevo) {
		return proveedorService.agregarProveedor(nuevo);
	}

	@PutMapping("")
	public Proveedor actualizarProveedor(@RequestBody ActualizarProveedor proveedor) {
		return proveedorService.actualizarProveedor(proveedor);
	}

	@DeleteMapping("/{idProveedor}")
	public String eliminarProveedor(@PathVariable int idProveedor) {
		return proveedorService.eliminarProveedor(idProveedor);
	}
}
