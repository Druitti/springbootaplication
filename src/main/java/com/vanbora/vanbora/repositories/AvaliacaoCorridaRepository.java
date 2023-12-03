package com.vanbora.vanbora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.models.AvaliacaoCorrida;



@Repository
public interface AvaliacaoCorridaRepository extends JpaRepository<AvaliacaoCorrida,Long> {
    
    
    

}
