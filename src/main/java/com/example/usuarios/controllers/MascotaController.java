package com.example.usuarios.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.entities.Mascota;
import com.example.usuarios.repositories.MascotaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MascotaController {
    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping("/mascotas")
    public List<Mascota> mascotas() {
        return mascotaRepository.findAll();
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<Mascota> obtenerMascota(@PathVariable Long id){
        return mascotaRepository.findById(id).map(
            mascota -> ResponseEntity.ok(mascota)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/mascota")
    public ResponseEntity<Mascota> agregarMascota(@RequestBody Mascota mascota){
        Mascota mascotaSave = mascotaRepository.save(mascota);
        return ResponseEntity.ok(mascotaSave);
    }
}
