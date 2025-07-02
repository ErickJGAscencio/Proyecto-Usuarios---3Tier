package com.example.usuarios.mappers;

import com.example.usuarios.dtos.EstudianteDtoConCurso;
import com.example.usuarios.dtos.EstudianteDtoSimple;
import com.example.usuarios.entities.Estudiante;

public class EstudianteMapper {
    public static EstudianteDtoSimple toSimple(Estudiante e) {
        return new EstudianteDtoSimple(e.getId(), e.getNombre(), e.getEmail());
    }

    public static EstudianteDtoConCurso toConCurso(Estudiante e) {
        EstudianteDtoConCurso dto = new EstudianteDtoConCurso();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setEmail(e.getEmail());

        if (e.getCurso() != null) {
            dto.setCursoId(e.getCurso().getId());
            dto.setNombreCurso(e.getCurso().getNombre());
        }

        return dto;
    }

}
