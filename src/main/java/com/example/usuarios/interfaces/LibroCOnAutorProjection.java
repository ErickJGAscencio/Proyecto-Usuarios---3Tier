package com.example.usuarios.interfaces;

public interface LibroCOnAutorProjection {
    String getTitulo();
    Double getPrecio();
    AutorInfo getAutor();

    interface AutorInfo{
        String getnombre();
    }
}
