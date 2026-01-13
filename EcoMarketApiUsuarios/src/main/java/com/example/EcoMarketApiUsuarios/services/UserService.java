package com.example.EcoMarketApiUsuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.EcoMarketApiUsuarios.models.entities.User;
import com.example.EcoMarketApiUsuarios.models.request.ActualizarUser;
import com.example.EcoMarketApiUsuarios.models.request.AgregarUser;
import com.example.EcoMarketApiUsuarios.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> obtenerTodosLosUsers(){
        return userRepository.findAll();
    }

    public User obtenerUserPorId(int userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
 
        }
        return user;
    }


    public User  agregarUser(AgregarUser nuevo){
        User user = new User();
        user.setNombre(nuevo.getNombre());
        user.setEmail(nuevo.getEmail());
        user.setPassword(nuevo.getPassword());

        return userRepository.save(user);
    }

    public User actualizarUser(ActualizarUser nuevo){
        User user = userRepository.findById(nuevo.getId()).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
 
        }else{
            user.setNombre(nuevo.getNombre());
            user.setEmail(nuevo.getEmail());
            user.setPassword(nuevo.getPassword());
            return userRepository.save(user);
        }
    }

    public String eliminarUser(int userId){
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "Usuario eliminado.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca no encontrada.");
       }
    }
}
