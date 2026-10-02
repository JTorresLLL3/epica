package com.utch.epica.repository;

import com.utch.epica.model.Avistamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvistamientoRepository extends JpaRepository<Avistamiento, Long> {
    List<Avistamiento> findByEspecieContainingIgnoreCase(String especie);
    List<Avistamiento> findByUbicacionGeograficaContainingIgnoreCase(String ubicacionGeografica);
}
