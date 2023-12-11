package com.vanbora.vanbora.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vanbora.vanbora.models.SuporteAoUsuario;

@Repository
public interface SuporteAoUsuarioRepository extends JpaRepository<SuporteAoUsuario,Long> {


   /*  @Query("SELECT " +
            "SUM(CASE WHEN nome_da_coluna_de_estrelas = 5 THEN 1 ELSE 0 END) AS qtd_estrelas_5, " +
            "SUM(CASE WHEN nome_da_coluna_de_estrelas = 4 THEN 1 ELSE 0 END) AS qtd_estrelas_4, " +
            "SUM(CASE WHEN nome_da_coluna_de_estrelas = 3 THEN 1 ELSE 0 END) AS qtd_estrelas_3, " +
            "SUM(CASE WHEN nome_da_coluna_de_estrelas = 2 THEN 1 ELSE 0 END) AS qtd_estrelas_2, " +
            "SUM(CASE WHEN nome_da_coluna_de_estrelas = 1 THEN 1 ELSE 0 END) AS qtd_estrelas_1 " +
            "FROM SuporteAoUsuario")
    Object contarEstrelas();*/
}
