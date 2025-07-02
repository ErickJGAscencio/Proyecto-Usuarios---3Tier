package com.example.usuarios.dtos;

public class EstudianteDtoConCurso extends EstudianteDtoBase {
    private Long cursoId;
    private String nombreCurso;
    
    public EstudianteDtoConCurso() {
    }

    public EstudianteDtoConCurso(Long id, String nombre, String email, Long cursoId, String nombreCurso) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cursoId = cursoId;
        this.nombreCurso = nombreCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
}
