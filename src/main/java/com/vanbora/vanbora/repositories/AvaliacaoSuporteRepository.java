package com.vanbora.vanbora.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.models.AvaliacaoSuporte;

@Repository
public interface AvaliacaoSuporteRepository extends JpaRepository<AvaliacaoSuporte,Long> {
    
  
   
}
