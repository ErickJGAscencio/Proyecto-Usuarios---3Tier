package com.example.usuarios.mappers;

import com.example.usuarios.dtos.MascotaDto;
import com.example.usuarios.entities.Mascota;
import com.example.usuarios.entities.Usuario;

public class MascotaMapper {
    public static MascotaDto toDto(Mascota mascota){
        return new MascotaDto(
            mascota.getId(),
            mascota.getNombre(),
            mascota.getEdad(),
            mascota.getUsuario() != null ? mascota.getUsuario().getId() : null
        );
    }

    public static Mascota toEntity(MascotaDto dto, Usuario usuario){
        Mascota mascota = new Mascota();
        mascota.setId(dto.getId());
        mascota.setNombre(dto.getNombre());
        mascota.setEdad(dto.getEdad());
        mascota.setUsuario(usuario);

        return mascota;
    }
}
