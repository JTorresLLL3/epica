package com.utch.epica.repository;

import com.utch.epica.model.ResenaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResenaLibroRepository extends JpaRepository<ResenaLibro, Long> {
    List<ResenaLibro> findByTituloLibroContainingIgnoreCase(String tituloLibro);
    List<ResenaLibro> findByAutorLibroContainingIgnoreCase(String autorLibro);
}
