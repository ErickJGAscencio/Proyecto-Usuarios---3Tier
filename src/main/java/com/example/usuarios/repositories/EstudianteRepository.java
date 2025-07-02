package com.example.usuarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByCursoId(Long cursoId);
}
