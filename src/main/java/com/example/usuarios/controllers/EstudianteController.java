package com.example.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private EstudianteService service;

    @PostMapping("/curso/{cursoId}")
    public EstudianteDtoConCurso crear(@RequestBody EstudianteDtoSimple dto, @PathVariable Long cursoId) {
        return service.crear(dto, cursoId);
    }

    @GetMapping
    public List<EstudianteDtoConCurso> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDtoConCurso> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public List<EstudianteDtoSimple> listarPorCurso(@PathVariable Long cursoId) {
        return service.listarPorCurso(cursoId);
    }
}

