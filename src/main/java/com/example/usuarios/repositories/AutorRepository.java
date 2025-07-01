package com.example.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
