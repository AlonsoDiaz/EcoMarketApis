package com.example.EcoMarketApiPermisos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketApiPermisos.models.entities.Permisos;
import com.example.EcoMarketApiPermisos.models.request.ActualizarPermisos;
import com.example.EcoMarketApiPermisos.models.request.AgregarPermiso;
import com.example.EcoMarketApiPermisos.services.PermisoService;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;



@RequestMapping("permiso")
@RestController
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping("")
    public List<Permisos> obtenerTodo(){
        return permisoService.obtenerTodosLosPermisos();
    }

    @GetMapping("/{idPermiso}")
    public EntityModel<Permisos> obtenerPorId(@PathVariable int idPermiso){
        Permisos permisos = permisoService.ObtenerPermisoPorId(idPermiso);

        Link deleteLink = linkTo(PermisoController.class).slash(idPermiso).withRel("Eliminar Permiso");
        Link selfLink = linkTo(methodOn(PermisoController.class).obtenerTodo()).withRel("Obtener todos los permisos");

        return EntityModel.of(permisos, deleteLink, selfLink);
    }

    @PostMapping("")
    public Permisos agregarPermisos(@RequestBody AgregarPermiso nuevo){
        return permisoService.agregarPermiso(nuevo);
    }

    @PutMapping("")
    public Permisos actualizaPermisos(@RequestBody ActualizarPermisos nueva){
        return permisoService.actualizarPermiso(nueva); 
    }

    @DeleteMapping("/{idPermiso}")
    public String eliminarPermiso(@PathVariable int idPermiso){
        return permisoService.eliminarPermiso(idPermiso);
    }
    
    
    
    

}
