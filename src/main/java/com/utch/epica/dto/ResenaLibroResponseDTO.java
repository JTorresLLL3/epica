package com.utch.epica.dto;

import java.time.LocalDateTime;

public class ResenaLibroResponseDTO {

    private Long id;
    private String tituloLibro;
    private String autorLibro;
    private String comentario;
    private Integer puntuacion;
    private LocalDateTime fechaPublicacion;

    public ResenaLibroResponseDTO() {
    }

    public ResenaLibroResponseDTO(Long id, String tituloLibro, String autorLibro, String comentario, Integer puntuacion, LocalDateTime fechaPublicacion) {
        this.id = id;
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
