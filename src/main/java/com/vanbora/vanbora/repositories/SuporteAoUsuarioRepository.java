package com.vanbora.vanbora.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vanbora.vanbora.models.SuporteAoUsuario;

@Repository
public interface SuporteAoUsuarioRepository extends JpaRepository<SuporteAoUsuario,Long> {


    @Query("SELECT (SUM(CASE WHEN s.statusSolicitacao = 'RESOLVIDO' THEN 1 ELSE 0 END) / COUNT(*)) * 100 AS porcentagem " +
       "FROM SuporteAoUsuario s")


    Object SuportesResolvidosPorcentagem();
}
