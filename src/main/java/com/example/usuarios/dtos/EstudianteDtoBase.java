package com.example.usuarios.dtos;

public class EstudianteDtoBase {
    protected Long id;
    protected String nombre;
    protected String email;
    
    public EstudianteDtoBase() { }

    public EstudianteDtoBase(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
}
