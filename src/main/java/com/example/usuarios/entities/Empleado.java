package com.example.usuarios.entities;

import jakarta.persistence.Entity;

@Entity
public class Empleado extends Miembro{
    private Double salario;
    
    public Empleado(){}
    public Empleado(Double salario){this.salario = salario;}

    public void setSalario(Double salario){this.salario = salario;}
    public Double getSalario(){return this.salario;}
}
