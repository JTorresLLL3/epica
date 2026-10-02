package com.utch.epica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utch.epica.dto.AvistamientoRequestDTO;
import com.utch.epica.dto.ResenaLibroRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EpicaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("HU 1.1: Registrar Avistamiento de Fauna Silvestre")
    void testRegistrarAvistamiento() throws Exception {
        AvistamientoRequestDTO dto = new AvistamientoRequestDTO(
                "Jaguar (Panthera onca)",
                "Reserva Biosfera Calakmul",
                LocalDate.of(2026, 10, 1),
                "Ejemplar adulto cerca del cuerpo de agua"
        );

        mockMvc.perform(post("/api/avistamientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.especie").value("Jaguar (Panthera onca)"));
    }

    @Test
    @DisplayName("HU 1.2: Consultar Avistamientos")
    void testConsultarAvistamientos() throws Exception {
        mockMvc.perform(get("/api/avistamientos"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("HU 3.1: Publicar Reseña de Libro")
    void testPublicarResena() throws Exception {
        ResenaLibroRequestDTO dto = new ResenaLibroRequestDTO(
                "Cien Años de Soledad",
                "Gabriel García Márquez",
                "Obra maestra del realismo mágico.",
                5
        );

        mockMvc.perform(post("/api/resenas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.tituloLibro").value("Cien Años de Soledad"));
    }

    @Test
    @DisplayName("HU 3.2: Consultar Reseñas por Título")
    void testConsultarResenas() throws Exception {
        mockMvc.perform(get("/api/resenas").param("tituloLibro", "Cien Años"))
                .andExpect(status().isOk());
    }
}
