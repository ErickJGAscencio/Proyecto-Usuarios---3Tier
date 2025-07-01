package com.example.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.entities.Autor;
import com.example.usuarios.repositories.AutorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AutorController {
    @Autowired
    public AutorRepository autorRepository;

    @GetMapping("/autores")
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @PostMapping("/autor")
    public Autor addAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
    
    
}
