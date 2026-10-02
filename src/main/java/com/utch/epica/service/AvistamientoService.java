package com.utch.epica.service;

import com.utch.epica.dto.AvistamientoRequestDTO;
import com.utch.epica.dto.AvistamientoResponseDTO;
import com.utch.epica.model.Avistamiento;
import com.utch.epica.repository.AvistamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvistamientoService {

    private final AvistamientoRepository avistamientoRepository;

    public AvistamientoService(AvistamientoRepository avistamientoRepository) {
        this.avistamientoRepository = avistamientoRepository;
    }

    public AvistamientoResponseDTO registrarAvistamiento(AvistamientoRequestDTO dto) {
        Avistamiento avistamiento = new Avistamiento(
                dto.getEspecie(),
                dto.getUbicacionGeografica(),
                dto.getFechaAvistamiento(),
                dto.getObservaciones()
        );
        Avistamiento guardado = avistamientoRepository.save(avistamiento);
        return mapToDTO(guardado);
    }

    public List<AvistamientoResponseDTO> obtenerTodosAvistamientos() {
        return avistamientoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AvistamientoResponseDTO> buscarPorEspecie(String especie) {
        return avistamientoRepository.findByEspecieContainingIgnoreCase(especie)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AvistamientoResponseDTO mapToDTO(Avistamiento entity) {
        return new AvistamientoResponseDTO(
                entity.getId(),
                entity.getEspecie(),
                entity.getUbicacionGeografica(),
                entity.getFechaAvistamiento(),
                entity.getObservaciones()
        );
    }
}
