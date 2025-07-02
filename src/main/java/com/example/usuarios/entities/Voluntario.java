package com.example.usuarios.entities;

import jakarta.persistence.Entity;

@Entity
public class Voluntario extends Miembro{
    private Integer horasPorSemana;
    
    public Voluntario(){}
    public Voluntario(Integer horasPorSemana){this.horasPorSemana = horasPorSemana;}

    public void setHorasPorSemana(Integer horasPorSemana){this.horasPorSemana = horasPorSemana;}
    public Integer getHorasPorSemana(){return this.horasPorSemana;}
}
