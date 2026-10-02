package com.utch.epica.controller;

import com.utch.epica.dto.ResenaLibroRequestDTO;
import com.utch.epica.dto.ResenaLibroResponseDTO;
import com.utch.epica.service.ResenaLibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenaLibroController {

    private final ResenaLibroService resenaLibroService;

    public ResenaLibroController(ResenaLibroService resenaLibroService) {
        this.resenaLibroService = resenaLibroService;
    }

    // HU 3.1: Publicar reseña de libro
    @PostMapping
    public ResponseEntity<ResenaLibroResponseDTO> publicarResena(@Valid @RequestBody ResenaLibroRequestDTO requestDTO) {
        ResenaLibroResponseDTO creada = resenaLibroService.publicarResena(requestDTO);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    // HU 3.2: Consultar reseñas asociadas a un libro específico (o todas)
    @GetMapping
    public ResponseEntity<List<ResenaLibroResponseDTO>> consultarResenas(
            @RequestParam(required = false) String tituloLibro) {
        if (tituloLibro != null && !tituloLibro.trim().isEmpty()) {
            return ResponseEntity.ok(resenaLibroService.obtenerResenasPorTitulo(tituloLibro));
        }
        return ResponseEntity.ok(resenaLibroService.obtenerTodasResenas());
    }
}
