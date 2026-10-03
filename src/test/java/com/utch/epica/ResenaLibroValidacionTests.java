package com.utch.epica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utch.epica.dto.ResenaLibroRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ResenaLibroValidacionTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private void enviarYEsperar(ResenaLibroRequestDTO dto, int statusEsperado) throws Exception {
        mockMvc.perform(post("/api/resenas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(statusEsperado));
    }

    @ParameterizedTest(name = "Puntuacion {0} fuera de rango -> 400")
    @ValueSource(ints = {0, 6, -1, 100})
    @DisplayName("Rechaza puntuaciones fuera del rango 1-5")
    void rechazaPuntuacionFueraDeRango(int puntuacion) throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "El Principito", "Antoine de Saint-Exupery", "Muy bueno", puntuacion);
        enviarYEsperar(dto, 400);
    }

    @ParameterizedTest(name = "Puntuacion {0} valida -> 201")
    @ValueSource(ints = {1, 5})
    @DisplayName("Acepta los limites validos 1 y 5")
    void aceptaLimitesValidos(int puntuacion) throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "El Principito", "Antoine de Saint-Exupery", "Muy bueno", puntuacion);
        enviarYEsperar(dto, 201);
    }

    @Test
    @DisplayName("Rechaza titulo vacio")
    void rechazaTituloVacio() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "", "Autor Cualquiera", "Comentario", 4);
        enviarYEsperar(dto, 400);
    }

    @Test
    @DisplayName("Rechaza autor vacio")
    void rechazaAutorVacio() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "Titulo", "   ", "Comentario", 4);
        enviarYEsperar(dto, 400);
    }

    @Test
    @DisplayName("Rechaza comentario vacio")
    void rechazaComentarioVacio() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "Titulo", "Autor", "", 4);
        enviarYEsperar(dto, 400);
    }

    @Test
    @DisplayName("Rechaza puntuacion nula")
    void rechazaPuntuacionNula() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "Titulo", "Autor", "Comentario", null);
        enviarYEsperar(dto, 400);
    }
}
    
}
