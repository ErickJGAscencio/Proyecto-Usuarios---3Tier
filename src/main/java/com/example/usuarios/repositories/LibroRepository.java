package com.example.usuarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.usuarios.entities.Libro;
import com.example.usuarios.interfaces.LibroProjections;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // --------------------------
    // Proyecciones dinámicas genéricas
    // --------------------------
    <T> List<T> findBy(Class<T> type);

    <T> List<T> findByPrecioGreaterThan(Double precio, Class<T> type);

    <T> List<T> findByPrecioLessThan(Double precio, Class<T> type);

    // --------------------------
    // Proyecciones específicas
    // --------------------------

    // Proyección básica
    List<LibroProjections.Basica> findBasicProjectionBy();

    // Proyección con autor
    List<LibroProjections.ConAutor> findWithAuthorProjectionBy();

    // 3. Proyección para libros largos (filtro + autor)
    @Query("SELECT l.titulo as titulo, l.precio as precio, a.nombre as autorNombre " +
            "FROM Libro l JOIN l.autor a WHERE l.paginas > :paginas")
    List<LibroProjections.ConAutor> findLibrosLargos(@Param("paginas") Integer paginas);
}