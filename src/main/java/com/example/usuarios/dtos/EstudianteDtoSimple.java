package com.example.usuarios.dtos;

public class EstudianteDtoSimple {
    private Long id;
    private String nombre;
    private String email;
    
    public EstudianteDtoSimple() {
    }

    public EstudianteDtoSimple(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
}