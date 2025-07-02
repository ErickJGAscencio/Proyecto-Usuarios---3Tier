package com.example.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuarios.entities.Libro;
// import com.example.usuarios.interfaces.LibroBasicoProjection;
import com.example.usuarios.interfaces.LibroCOnAutorProjection;
import com.example.usuarios.interfaces.LibroProjections;
import com.example.usuarios.repositories.LibroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LibroController {

    @Autowired
    private final LibroRepository libroRepository;

    LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // @GetMapping("/libros")
    // public List<Libro> obtenerTodos() {
    //     return libroRepository.findAll();
    // }
    @GetMapping("/libros")
    public List<LibroProjections.ConAutor> obtenerTodos() {
        return libroRepository.findWithAuthorProjectionBy();
    }

    @PostMapping("/libro")
    public Libro addLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    // @GetMapping("/libros/basicos")
    // public List<LibroBasicoProjection> getLibrosBasicos() {
    //     return libroRepository.findBy(LibroBasicoProjection.class);
    // }


    @GetMapping("/libros/basicos")
    public List<LibroProjections.Basica> getLibrosBasicos() {
        return libroRepository.findBy(LibroProjections.Basica.class);
    }

    @GetMapping("/libros/caros")
    public List<LibroCOnAutorProjection> getLibrosCaros() {
        return libroRepository.findByPrecioGreaterThan(181.0, LibroCOnAutorProjection.class);
    }

    @GetMapping("/libros/largos")
    public List<LibroProjections.ConAutor> getLibrosLargos() {
        return libroRepository.findLibrosLargos(350);
    }

    // @GetMapping("/libros/baratos")
    // public List<LibroCOnAutorProjection> getLibrosBaratos() {
    //     return libroRepository.findByPrecioLowerThan(180.0, LibroCOnAutorProjection.class);
    // }
}
