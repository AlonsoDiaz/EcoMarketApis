package com.example.EcoMarketApiEnvios.controller;

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

import com.example.EcoMarketApiEnvios.models.entities.Envio;
import com.example.EcoMarketApiEnvios.models.request.ActualizarEnvio;
import com.example.EcoMarketApiEnvios.models.request.AgregarEnvio;
import com.example.EcoMarketApiEnvios.services.EnvioService;

@RequestMapping("envio")
@RestController
public class EnvioController {

	@Autowired
	private EnvioService envioService;

	@GetMapping("")
	public List<Envio> obtenerTodo(){
		return envioService.obtenerTodos();
	}

	@GetMapping("/{idEnvio}")
	public Envio obtenerPorId(@PathVariable int idEnvio){
		return envioService.obtenerEnvioPorId(idEnvio);
	}

	@PostMapping("")
	public Envio agregarEnvio(@RequestBody AgregarEnvio nuevo){
		return envioService.agregarEnvio(nuevo);
	}

	@PutMapping("")
	public Envio actualizarEnvio(@RequestBody ActualizarEnvio nuevo){
		return envioService.actualizarEnvio(nuevo);
	}
    
	@DeleteMapping("/{idEnvio}")
	public String eliminarEnvio(@PathVariable int idEnvio){
		return envioService.eliminarEnvio(idEnvio);
	}
}
