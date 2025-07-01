package com.example.usuarios.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.entities.Usuario;
import com.example.usuarios.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String activity() {
        return "Se puede acceder a la API";
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    // @RequestMapping(path = "/usuario/{id}", method=RequestMethod.DELETE)
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        return usuarioService.eliminarUsuario(id);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
    // public String agregarUsuario(@RequestBody Usuario usuario) {
        // Long id = usuarios.stream().mapToLong(Usuario::getId).max().orElse(0) + 1;
        // usuario.setId(id);
        // usuarios.add(usuario);
        // return "Usuaro correctamente añadido";
        return usuarioService.agregarUsuario(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<String> modificarUsuario(@PathVariable Long id, @RequestBody Usuario datos) {
        return usuarioService.modificarUsuario(id, datos);
    }
}
