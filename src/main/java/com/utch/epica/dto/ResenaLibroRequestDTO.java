package com.utch.epica.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ResenaLibroRequestDTO {

    @NotBlank(message = "El título del libro es obligatorio")
    private String tituloLibro;

    @NotBlank(message = "El nombre del autor es obligatorio")
    private String autorLibro;

    @NotBlank(message = "El comentario de la reseña es obligatorio")
    private String comentario;

    @NotNull(message = "La puntuación es obligatoria")
    @Min(value = 1, message = "La puntuación mínima es 1")
    @Max(value = 5, message = "La puntuación máxima es 5")
    private Integer puntuacion;

    public ResenaLibroRequestDTO() {
    }

    public ResenaLibroRequestDTO(String tituloLibro, String autorLibro, String comentario, Integer puntuacion) {
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
