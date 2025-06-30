package com.example.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota,Long>{
    
}
