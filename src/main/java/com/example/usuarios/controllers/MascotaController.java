package com.example.usuarios.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.dtos.MascotaDto;
import com.example.usuarios.entities.Mascota;
import com.example.usuarios.services.MascotaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/mascotas")
    public List<Mascota> obtenerTodas() {
        // return mascotaRepository.findAll(); //Qutiamos esto de aquí y la colocamos en la capa de servicio, de esta forma separamos las responsabilidades
        // el controlador solo se encarga de pedir la solicitud al servicio quien es quien interactua con la base de datos.
        return mascotaService.obtenerTodas();
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id){
        return mascotaService.obtenerPorId(id);
    }

    @GetMapping("/mascota/usuario/{id}")
    public ResponseEntity<List<MascotaDto>> obtenerPorIdUsuario(@PathVariable Long id) {
        return mascotaService.obtenerPorIdUsuario(id);
    }
    
    @PostMapping("/mascota")
    public ResponseEntity<Mascota> agregarMascota(@RequestBody Mascota mascota){
        return mascotaService.agregarMascota(mascota);
    }

    @DeleteMapping("/mascota/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable Long id){
        return mascotaService.eliminarMascota(id);
    }

    @PutMapping("mascota/{id}")
    public ResponseEntity<String> modificarMascota(@PathVariable Long id, @RequestBody Mascota data){
        return mascotaService.modificarMascota(id, data);
    }
}
