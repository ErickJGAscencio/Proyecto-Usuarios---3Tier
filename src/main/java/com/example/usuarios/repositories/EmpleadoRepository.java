package com.example.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
