package com.example.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuarios.dtos.EstudianteDtoConCurso;
import com.example.usuarios.dtos.EstudianteDtoSimple;
import com.example.usuarios.entities.Curso;
import com.example.usuarios.entities.Estudiante;
import com.example.usuarios.mappers.EstudianteMapper;
import com.example.usuarios.repositories.CursoRepository;
import com.example.usuarios.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepo;
    @Autowired
    private CursoRepository cursoRepo;

    public EstudianteDtoConCurso crear(EstudianteDtoSimple dto, Long cursoId) {
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setEmail(dto.getEmail());
        estudiante.setCurso(curso);
        return EstudianteMapper.toConCurso(estudianteRepo.save(estudiante));
    }

    public List<EstudianteDtoConCurso> listarTodos() {
        return estudianteRepo.findAll().stream().map(EstudianteMapper::toConCurso).toList();
    }

    public List<EstudianteDtoSimple> listarPorCurso(Long cursoId) {
        return estudianteRepo.findByCursoId(cursoId).stream().map(EstudianteMapper::toSimple).toList();
    }

    public Optional<EstudianteDtoConCurso> obtenerPorId(Long id) {
        return estudianteRepo.findById(id).map(EstudianteMapper::toConCurso);
    }
}
