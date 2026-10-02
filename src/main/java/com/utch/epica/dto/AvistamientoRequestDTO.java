package com.utch.epica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvistamientoRequestDTO {

    @NotBlank(message = "La especie es obligatoria")
    private String especie;

    @NotBlank(message = "La ubicación geográfica es obligatoria")
    private String ubicacionGeografica;

    @NotNull(message = "La fecha de avistamiento es obligatoria")
    private LocalDate fechaAvistamiento;

    private String observaciones;

    public AvistamientoRequestDTO() {
    }

    public AvistamientoRequestDTO(String especie, String ubicacionGeografica, LocalDate fechaAvistamiento, String observaciones) {
        this.especie = especie;
        this.ubicacionGeografica = ubicacionGeografica;
        this.fechaAvistamiento = fechaAvistamiento;
        this.observaciones = observaciones;
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
