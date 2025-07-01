package com.example.usuarios.interfaces;

public class LibroProjections {

    // Proyección básica
    public interface Basica {
        Long getLibroId();
        String getTitulo();
        Integer getPaginas();
    }

    // Proyección con autor (annidada)
    public interface ConAutor {
        String getTitulo();

        Double getPrecio();

        AutorInfo getAutor();

        interface AutorInfo {
            String getNombre();

            String getNacionalidad(); // Ejemplo de campo adicional
        }
    }

    public interface LibroConAutorProjection {
        Long getLibroId();
        String getTitulo();

        AutorMinimoProjection getAutor(); // Proyección anidada

        interface AutorMinimoProjection {
            Long getAutorId();
            String getNombre();
            // Excluir 'libros' para evitar recursión
        }
    }
}