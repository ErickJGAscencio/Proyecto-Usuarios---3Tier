package com.example.usuarios.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MASCOTAS")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASCOTA_ID")
    private Long id;
    private String nombre;
    private Integer edad;
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    public Mascota(){}
    
    public Mascota(Long id, String nombre, Integer edad, Usuario usuario){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.usuario = usuario;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Integer getEdad(){
        return this.edad;
    }
    public void setEdad(Integer edad){
        this.edad = edad;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
