package com.utch.epica.dto;

import java.time.LocalDate;

public class AvistamientoResponseDTO {

    private Long id;
    private String especie;
    private String ubicacionGeografica;
    private LocalDate fechaAvistamiento;
    private String observaciones;

    public AvistamientoResponseDTO() {
    }

    public AvistamientoResponseDTO(Long id, String especie, String ubicacionGeografica, LocalDate fechaAvistamiento, String observaciones) {
        this.id = id;
        this.especie = especie;
        this.ubicacionGeografica = ubicacionGeografica;
        this.fechaAvistamiento = fechaAvistamiento;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public LocalDate getFechaAvistamiento() {
        return fechaAvistamiento;
    }

    public void setFechaAvistamiento(LocalDate fechaAvistamiento) {
        this.fechaAvistamiento = fechaAvistamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
