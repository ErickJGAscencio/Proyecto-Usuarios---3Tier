package com.example.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.dtos.EstudianteDtoConCurso;
import com.example.usuarios.dtos.EstudianteDtoSimple;
import com.example.usuarios.services.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteDtoConCurso> listarTodos() {
        return estudianteService.listarTodos();
    }

    @PostMapping
    public EstudianteDtoConCurso crear(@RequestBody EstudianteDtoSimple dto) {
        return estudianteService.crear(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDtoConCurso> obtenerPorId(@PathVariable Long id) {
        return estudianteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public List<EstudianteDtoSimple> listarPorCurso(@PathVariable Long cursoId) {
        return estudianteService.listarPorCurso(cursoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id){
        return estudianteService.eliminarEstudiante(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDtoConCurso> actualizarEstudiante(@RequestBody EstudianteDtoConCurso dto, @PathVariable Long id){
        return estudianteService.actualizarEstudiante(dto, id);
    }
}

