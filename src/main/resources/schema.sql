-- Script de Creación de Tabla para PostgreSQL (Épica 3 - Reseñas de Libros)

CREATE TABLE IF NOT EXISTS resenas_libros (
    id BIGSERIAL PRIMARY KEY,
    titulo_libro VARCHAR(255) NOT NULL,
    autor_libro VARCHAR(255) NOT NULL,
    comentario TEXT NOT NULL,
    puntuacion INT NOT NULL CHECK (puntuacion >= 1 AND puntuacion <= 5),
    fecha_publicacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
