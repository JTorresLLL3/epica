package com.utch.epica.service;

import com.utch.epica.dto.ResenaLibroRequestDTO;
import com.utch.epica.dto.ResenaLibroResponseDTO;
import com.utch.epica.model.ResenaLibro;
import com.utch.epica.repository.ResenaLibroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResenaLibroService {

    private final ResenaLibroRepository resenaLibroRepository;

    public ResenaLibroService(ResenaLibroRepository resenaLibroRepository) {
        this.resenaLibroRepository = resenaLibroRepository;
    }

    // HU 3.1: Publicar reseña de libro
    public ResenaLibroResponseDTO publicarResena(ResenaLibroRequestDTO dto) {
        ResenaLibro resena = new ResenaLibro(
                dto.getTituloLibro(),
                dto.getAutorLibro(),
                dto.getComentario(),
                dto.getPuntuacion(),
                LocalDateTime.now()
        );
        ResenaLibro guardada = resenaLibroRepository.save(resena);
        return mapToDTO(guardada);
    }

    private ResenaLibroResponseDTO mapToDTO(ResenaLibro entity) {
        return new ResenaLibroResponseDTO(
                entity.getId(),
                entity.getTituloLibro(),
                entity.getAutorLibro(),
                entity.getComentario(),
                entity.getPuntuacion(),
                entity.getFechaPublicacion()
        );
    }
}
