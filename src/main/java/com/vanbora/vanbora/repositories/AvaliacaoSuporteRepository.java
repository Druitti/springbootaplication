package com.vanbora.vanbora.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.DTOs.ContagemEstrelasDTO;
import com.vanbora.vanbora.models.AvaliacaoSuporte;

@Repository
public interface AvaliacaoSuporteRepository extends JpaRepository<AvaliacaoSuporte,Long> {

    @Query("SELECT " +
            "new com.vanbora.vanbora.DTOs.ContagemEstrelasDTO(" +
            "SUM(CASE WHEN estrelas = 5 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN estrelas = 4 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN estrelas = 3 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN estrelas = 2 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN estrelas = 1 THEN 1 ELSE 0 END)) " +
            "FROM AvaliacaoSuporte")
ContagemEstrelasDTO contarEstrelas();
  
   
}
