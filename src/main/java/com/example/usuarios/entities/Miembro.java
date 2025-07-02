package com.example.usuarios.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long miembroId;
    private String nombre;

    public Miembro(){}
    public Miembro(Long miembroId, String nombre){
        this.miembroId = miembroId;
        this.nombre = nombre;
    }

    public void setMiembroId(Long miembroId){ this.miembroId = miembroId;}
    public Long getMiembroId(){ return this.miembroId; }

    public void setNombre(String nombre){ this.nombre = nombre;}
    public String getNombre(){return this.nombre;}
}
