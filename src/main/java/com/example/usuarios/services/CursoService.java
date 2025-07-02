package com.example.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuarios.dtos.CursoDto;
import com.example.usuarios.entities.Curso;
import com.example.usuarios.repositories.CursoRepository;

@Service
public class CursoService { 
    @Autowired
    private CursoRepository cursoRepository;

 public CursoDto crear(CursoDto dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        return toDto(cursoRepository.save(curso));
    }

    public List<CursoDto> listarTodos() {
        return cursoRepository.findAll().stream().map(this::toDto).toList();
    }

    public Optional<CursoDto> obtenerPorId(Long id) {
        return cursoRepository.findById(id).map(this::toDto);
    }

    public Optional<CursoDto> actualizar(Long id, CursoDto dto) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(dto.getNombre());
            return toDto(cursoRepository.save(curso));
        });
    }

    public boolean eliminar(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CursoDto toDto(Curso curso) {
        return new CursoDto(curso.getId(), curso.getNombre());
    }
}
