package com.example.usuarios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LIBROS")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroId;
    
    private String titulo;
    private Integer paginas;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "autor_id") // nombre de columna FK en BD
    private Autor autor; // Nombre del atributo (importante para mappedBy) Esto es un objeto

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}