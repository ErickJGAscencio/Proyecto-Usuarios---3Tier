package com.example.usuarios.services;

import java.util.List;
import com.example.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.usuarios.entities.Mascota;
import com.example.usuarios.repositories.MascotaRepository;

@Service
public class MascotaService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    MascotaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    public ResponseEntity<Mascota> obtenerPorId(Long id) {
        return mascotaRepository.findById(id).map(
            mascota -> ResponseEntity.ok(mascota)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Mascota> agregarMascota(Mascota mascota){
        Mascota mascotaGuardar = mascotaRepository.save(mascota);
        return ResponseEntity.ok(mascotaGuardar);
    }

    public ResponseEntity<String> eliminarMascota(Long id){
        return mascotaRepository.findById(id)
        .map( mascota -> {
            mascotaRepository.delete(mascota);
            return ResponseEntity.ok("Mascota eliminada correctamente");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no enctrada"));
    }

    public ResponseEntity<String> modificarMascota(Long id, Mascota data){
        return mascotaRepository.findById(id)
        .map(mascota -> {
            mascota.setNombre(data.getNombre());
            mascota.setEdad(data.getEdad());
            mascota.setUsuario(data.getUsuario());
            mascotaRepository.save(mascota);
            return ResponseEntity.ok("Mascota actualizada exitosamente");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada"));

        // MascotaDto dto = new MascotaDto();
        // dto.setId(mascota.getId());
        // dto.setNombre(mascota.getNombre());
        // dto.setEdad(mascota.getEdad());
        // dto.setUsuarioId(mascota.getUsuario().getId());
    }
}
