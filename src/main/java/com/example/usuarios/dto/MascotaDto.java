package com.example.usuarios.dto;

public class MascotaDto {
    private Long id;
    private String nombre;
    private Integer edad;
    private Long usuarioId;

    public MascotaDto() {}

    public MascotaDto(Long id, String nombre, Integer edad, Long usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.usuarioId = usuarioId;
    }
    
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
