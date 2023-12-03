package com.vanbora.vanbora.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vanbora.vanbora.models.Usuario;






@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    
}
