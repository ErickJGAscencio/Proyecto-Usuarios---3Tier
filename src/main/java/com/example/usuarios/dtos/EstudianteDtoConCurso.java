package com.example.usuarios.dtos;

public class EstudianteDtoConCurso extends EstudianteDtoBase {
    private String nombreCurso;
    
    public EstudianteDtoConCurso() {
    }

    public EstudianteDtoConCurso(Long id, String nombre, String email, String nombreCurso) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.nombreCurso = nombreCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
}
