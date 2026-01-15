package com.example.EcomarketAPIgerente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EcomarketAPIgerente.models.entities.Gerente;
import com.example.EcomarketAPIgerente.models.request.AgregarMarca;
import com.example.EcomarketAPIgerente.services.GerenteService;

@RestController
@RequestMapping("gerente")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public List<Gerente> obtenerTodosLosGerentes() {
        return gerenteService.obtenerTodasLasMarcas();
    }

    @GetMapping("/{id}")
    public Gerente obtenerGerentePorId(@PathVariable int id) {
        return gerenteService.obtenerGerentePorId(id);
    }

    @PostMapping
    public Gerente agregarGerente(@RequestBody AgregarMarca nueva) {
        return gerenteService.agregarGerente(nueva);
    }

    @PutMapping
    public Gerente actualizarGerente(@RequestBody Gerente gerente) {
        return gerenteService.actualizarGerente(gerente);
    }

    @DeleteMapping("/{id}")
    public String eliminarGerente(@PathVariable int id) {
        return gerenteService.eliminarGerente(id);
    }
}
