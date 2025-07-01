package com.example.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.usuarios.entities.Mascota;
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

    public ResponseEntity<Mascota> agregarMascota(Mascota mascota){
        Mascota mascotaGuardar = mascotaRepository.save(mascota);
        return ResponseEntity.ok(mascotaGuardar);
    }
}
