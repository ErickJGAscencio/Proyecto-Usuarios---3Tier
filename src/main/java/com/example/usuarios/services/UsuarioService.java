package com.example.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.usuarios.entities.Usuario;
import com.example.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    
    public ResponseEntity<Usuario> obtenerPorId(Long id){
        // return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst().orElse(null);
        return usuarioRepository.findById(id).map(
            mascota -> ResponseEntity.ok(mascota)).orElse(
                ResponseEntity.notFound().build()
            );
        // return usuarioRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Usuario> agregarUsuario(Usuario usuario){
        Usuario usuarioSave = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioSave);
    } 

    public ResponseEntity<String> eliminarUsuario(Long id){
        // Usuario usuario = usuarios.stream().filter(us -> us.getId().equals(id)).findFirst().orElse(null);
        // if (usuario != null) {
        //     usuarios.remove(usuario);
        //     return "Usuario eliminado exitosamente";
        // } 
        // return "Usuario no encontrado";
        return usuarioRepository.findById(id)
        .map( usuario -> {
            usuarioRepository.delete(usuario);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        })
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
    }

    public ResponseEntity<String> modificarUsuario(Long id, Usuario data){
        return usuarioRepository.findById(id)
        .map(usuario -> {
            usuario.setNombre(data.getNombre());
            usuario.setEmail(data.getEmail());
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuario actualizado exitosamente");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
    }
}
