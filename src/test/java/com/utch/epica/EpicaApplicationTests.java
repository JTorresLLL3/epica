package com.utch.epica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utch.epica.dto.ResenaLibroRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EpicaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("HU 3.1: Publicar Reseña de Libro (Joel Torres)")
    void testPublicarResena() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "Cien Años de Soledad",
                "Gabriel García Márquez",
                "Una joya de la literatura hispanoamericana.",
                5
        );

        mockMvc.perform(post("/api/resenas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.tituloLibro").value("Cien Años de Soledad"))
                .andExpect(jsonPath("$.autorLibro").value("Gabriel García Márquez"))
                .andExpect(jsonPath("$.puntuacion").value(5));
    }
}
