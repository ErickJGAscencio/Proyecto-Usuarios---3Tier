package com.example.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuarios.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
