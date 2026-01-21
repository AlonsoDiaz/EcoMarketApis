package com.example.EcoMarketApiUsuarios.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import com.example.EcoMarketApiUsuarios.models.entities.User;
import com.example.EcoMarketApiUsuarios.models.request.ActualizarUser;
import com.example.EcoMarketApiUsuarios.models.request.AgregarUser;
import com.example.EcoMarketApiUsuarios.services.UserService;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> obtenerTodo(){
        return userService.obtenerTodosLosUsers();
    }

    @GetMapping("/{idUser}")
    public EntityModel<User> obtenerPorId(@PathVariable int idUser){
        User user = userService.obtenerUserPorId(idUser);

        Link deleteLink = linkTo(UserController.class).slash(idUser).withRel("Eliminar usuario");
        Link selfLink = linkTo(methodOn(UserController.class).obtenerTodo()).withRel("Obtener todos los usuarios");
        return EntityModel.of(user,selfLink,deleteLink);

    }

    @PostMapping("")
    public User agregarUser(@RequestBody AgregarUser nuevo){
        return userService.agregarUser(nuevo);
    }

    @PutMapping("")
    public User actualizarUser(@RequestBody ActualizarUser nuevo){
        return userService.actualizarUser(nuevo);
    }
    
     @DeleteMapping("/{idUser}")
    public String eliminarUser(@PathVariable int idUser){
        return userService.eliminarUser(idUser);
    }
    
}
