package com.example.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
