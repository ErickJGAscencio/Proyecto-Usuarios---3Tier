package com.example.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoRepository cursoRepo;

    public List<EstudianteDtoConCurso> listarTodos() {
        return estudianteRepository.findAll().stream().map(EstudianteMapper::toConCurso).toList();
    }

    public EstudianteDtoConCurso crear(EstudianteDtoSimple dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setEmail(dto.getEmail());
        return EstudianteMapper.toConCurso(estudianteRepository.save(estudiante));
    }

    public List<EstudianteDtoSimple> listarPorCurso(Long cursoId) {
        return estudianteRepository.findByCursoId(cursoId).stream().map(EstudianteMapper::toSimple).toList();
    }

    public Optional<EstudianteDtoConCurso> obtenerPorId(Long id) {
        return estudianteRepository.findById(id).map(EstudianteMapper::toConCurso);
    }

    public ResponseEntity<String> eliminarEstudiante(Long id) {
        Optional<Estudiante> estudianteOpt = estudianteRepository.findById(id);

        if (estudianteOpt.isPresent()) {
            estudianteRepository.delete(estudianteOpt.get());
            return ResponseEntity.ok("Estudiante eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado.");
        }
    }

    public ResponseEntity<EstudianteDtoConCurso> actualizarEstudiante(EstudianteDtoConCurso dto, Long id) {
        System.out.print("CURSO ID" + " - " + dto.getNombre());
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setNombre(dto.getNombre());
            estudiante.setEmail(dto.getEmail());
            estudiante.setCurso(cursoRepo.findById(dto.getCursoId()).orElse(null));

            Estudiante actualizado = estudianteRepository.save(estudiante);
            EstudianteDtoConCurso dtoActualizado = EstudianteMapper.toConCurso(actualizado);
            return ResponseEntity.ok(dtoActualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

}
