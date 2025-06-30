package com.example.usuarios.dto;

public class MascotaDto {
    private String nombre;
    private Integer edad;
    private Long usuarioId;

    public MascotaDto() {}

    public MascotaDto(String nombre, Integer edad, Long usuarioId) {
        this.nombre = nombre;
        this.edad = edad;
        this.usuarioId = usuarioId;
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
