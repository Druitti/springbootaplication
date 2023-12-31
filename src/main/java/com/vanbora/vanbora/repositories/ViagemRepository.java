package com.vanbora.vanbora.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.DTOs.ContagemAvgPsgViagDTO;
import com.vanbora.vanbora.DTOs.PercentualDTO;
import com.vanbora.vanbora.DTOs.TipoViagemDTO;
import com.vanbora.vanbora.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem,Long>{
    
    @Query("SELECT " +
            "new com.vanbora.vanbora.DTOs.ContagemAvgPsgViagDTO(" +
            "SUM(CASE WHEN v.quantidadeDePassageiros < 4 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN v.quantidadeDePassageiros BETWEEN 4 AND 6 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN v.quantidadeDePassageiros BETWEEN 7 AND 10 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN v.quantidadeDePassageiros > 10 THEN 1 ELSE 0 END)) " +
            "FROM Viagem v")
    ContagemAvgPsgViagDTO calcularMediaPorFaixa();

    @Query("SELECT " +
       "    new com.vanbora.vanbora.DTOs.TipoViagemDTO(" +
       "    (SUM(CASE WHEN LOWER(v.tipoViagem) = 'compartilhada' THEN 1 ELSE 0 END) / COUNT(*)) * 100, " +
       "    (SUM(CASE WHEN LOWER(v.tipoViagem) = 'privada' THEN 1 ELSE 0 END) / COUNT(*)) * 100) " +
       "FROM Viagem v")
    TipoViagemDTO calcularPercentuais();


    
}
