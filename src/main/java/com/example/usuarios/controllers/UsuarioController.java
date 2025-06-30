package com.example.usuarios.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.entities.Usuario;
import com.example.usuarios.repositories.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String activity() {
        return "Se puede acceder a la API";
    }

    @GetMapping("/usuarios")
    public List<Usuario> usuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        // public Usuario getUsuario(@PathVariable Long id) {
        // return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst().orElse(null);
        return usuarioRepository.findById(id).map(
            usuario -> ResponseEntity.ok(usuario)).orElse(ResponseEntity.notFound().build());
        // return usuarioRepository.findById(id).orElse(null);
    }

    // @RequestMapping(path = "/usuario/{id}", method=RequestMethod.DELETE)
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id) {
        // Usuario usuario = usuarios.stream().filter(us -> us.getId().equals(id)).findFirst().orElse(null);
        // if (usuario != null) {
        //     usuarios.remove(usuario);
        //     return "Usuario eliminado exitosamente";
        // } 
        // return "Usuario no encontrado";
        return usuarioRepository.findById(id)
        .map(usuario -> {
            usuarioRepository.delete(usuario);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        })
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
}

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
    // public String agregarUsuario(@RequestBody Usuario usuario) {
        // Long id = usuarios.stream().mapToLong(Usuario::getId).max().orElse(0) + 1;
        // usuario.setId(id);
        // usuarios.add(usuario);
        // return "Usuaro correctamente añadido";
        Usuario usuarioSave = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioSave);        
    }

    @PutMapping("/usuario/{id}")
    public String modificarUsuario(@PathVariable Long id, @RequestBody Usuario datos) {
        // Usuario usuarioModificar = usuarios.stream().filter(us -> us.getId().equals(id)).findFirst().orElse(null);
        // if(usuarioModificar!=null){
        //     usuarioModificar.setNombre(usuario.getNombre());
        //     usuarioModificar.setEmail(usuario.getEmail());
            
        //     return "Se actualizó correctamente";
        // }
        // return "Usuario no encontrado";
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario!=null){
            usuario.setNombre(datos.getNombre());
            usuario.setEmail(datos.getEmail());
            usuarioRepository.save(usuario);
            return "Usuario actualizado exitosamente";
        }
        return "Usuario no encontrado";
    }
}
