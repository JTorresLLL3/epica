package com.utch.epica.repository;

import com.utch.epica.model.ResenaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaLibroRepository extends JpaRepository<ResenaLibro, Long> {
}
