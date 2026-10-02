package com.utch.epica.controller;

import com.utch.epica.dto.AvistamientoRequestDTO;
import com.utch.epica.dto.AvistamientoResponseDTO;
import com.utch.epica.service.AvistamientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avistamientos")
public class AvistamientoController {

    private final AvistamientoService avistamientoService;

    public AvistamientoController(AvistamientoService avistamientoService) {
        this.avistamientoService = avistamientoService;
    }

    // HU 1.1: Registrar nuevo avistamiento
    @PostMapping
    public ResponseEntity<AvistamientoResponseDTO> registrarAvistamiento(@Valid @RequestBody AvistamientoRequestDTO requestDTO) {
        AvistamientoResponseDTO creado = avistamientoService.registrarAvistamiento(requestDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // HU 1.2: Consultar todos los avistamientos (opcional filtrado por especie)
    @GetMapping
    public ResponseEntity<List<AvistamientoResponseDTO>> consultarAvistamientos(
            @RequestParam(required = false) String especie) {
        if (especie != null && !especie.trim().isEmpty()) {
            return ResponseEntity.ok(avistamientoService.buscarPorEspecie(especie));
        }
        return ResponseEntity.ok(avistamientoService.obtenerTodosAvistamientos());
    }
}
