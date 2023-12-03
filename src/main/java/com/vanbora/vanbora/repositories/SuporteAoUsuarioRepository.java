package com.vanbora.vanbora.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vanbora.vanbora.models.SuporteAoUsuario;

@Repository
public interface SuporteAoUsuarioRepository extends JpaRepository<SuporteAoUsuario,Long> {
 
    
    
}
