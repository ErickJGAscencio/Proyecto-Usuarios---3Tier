package com.example.usuarios.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;
    
    private String nombre;
    
    @OneToMany(mappedBy = "autor") // Debe coincidir con el atributo en Libro
    @JsonIgnore
    private List<Libro> libros;

    public Autor() {}

    public Autor(Long autorId, String nombre, List<Libro> libros) {
        this.autorId = autorId;
        this.nombre = nombre;
        this.libros = libros;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}