package com.example.usuarios.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.usuarios.dtos.MascotaDto;
import com.example.usuarios.entities.Mascota;
import com.example.usuarios.mappers.MascotaMapper;
import com.example.usuarios.repositories.MascotaRepository;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    public ResponseEntity<Mascota> obtenerPorId(Long id) {
        return mascotaRepository.findById(id).map(
            mascota -> ResponseEntity.ok(mascota)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<MascotaDto>> obtenerPorIdUsuario(Long usuario_id){
    // public ResponseEntity<List<Mascota>> obtenerPorIdUsuario(Long usuario_id){
        List<Mascota> mascotas = mascotaRepository.findByUsuarioId(usuario_id);
        if(mascotas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<MascotaDto> dtos = mascotas.stream()
        .map(MascotaMapper::toDto)
        .toList();

        // return ResponseEntity.ok(mascotas);
        return ResponseEntity.ok(dtos);
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
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada"));
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
    }
}
