package com.vanbora.vanbora.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem,Long>{
    
    
}
