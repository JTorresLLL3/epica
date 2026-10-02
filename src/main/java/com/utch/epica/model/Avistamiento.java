package com.utch.epica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "avistamientos")
public class Avistamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especie;
    private String ubicacionGeografica;
    private LocalDate fechaAvistamiento;
    private String observaciones;

    public Avistamiento() {
    }

    public Avistamiento(String especie, String ubicacionGeografica, LocalDate fechaAvistamiento, String observaciones) {
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
