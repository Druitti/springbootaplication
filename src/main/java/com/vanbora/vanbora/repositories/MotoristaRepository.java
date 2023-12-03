package com.vanbora.vanbora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vanbora.vanbora.models.Motorista;


@Repository
public interface MotoristaRepository extends JpaRepository<Motorista,Long> {
    
   
    
}
