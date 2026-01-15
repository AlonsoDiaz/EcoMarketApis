package com.example.EcoMarketApiRutas.controller;

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

import com.example.EcoMarketApiRutas.models.entities.Ruta;
import com.example.EcoMarketApiRutas.models.request.ActualizarRuta;
import com.example.EcoMarketApiRutas.models.request.AgregarRuta;
import com.example.EcoMarketApiRutas.services.RutaService;

@RequestMapping("ruta")
@RestController
public class RutaController {

	@Autowired
	private RutaService rutaService;

	@GetMapping("")
	public List<Ruta> obtenerTodo(){
		return rutaService.obtenerTodas();
	}

	@GetMapping("/{idRuta}")
	public Ruta obtenerPorId(@PathVariable int idRuta){
		return rutaService.obtenerPorId(idRuta);
	}

	@PostMapping("")
	public Ruta agregarRuta(@RequestBody AgregarRuta nueva){
		return rutaService.agregarRuta(nueva);
	}

	@PutMapping("")
	public Ruta actualizarRuta(@RequestBody ActualizarRuta cambios){
		return rutaService.actualizarRuta(cambios);
	}

	@DeleteMapping("/{idRuta}")
	public String eliminarRuta(@PathVariable int idRuta){
		return rutaService.eliminarRuta(idRuta);
	}
}
