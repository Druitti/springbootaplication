package com.vanbora.vanbora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbora.vanbora.models.SuporteAoUsuario;
import com.vanbora.vanbora.repositories.SuporteAoUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class SuporteAoUsuarioService {

    @Autowired
    private SuporteAoUsuarioRepository suporteAoUsuarioRepository;

    public SuporteAoUsuario findById(Long id) {
        Optional<SuporteAoUsuario> suporteAoUsuario = this.suporteAoUsuarioRepository.findById(id);
        return suporteAoUsuario.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + SuporteAoUsuario.class.getName()));
    }
    
    @Transactional
    public SuporteAoUsuario create(SuporteAoUsuario suporteAoUsuario) {
       suporteAoUsuario.setTicketID( null);
        
        return suporteAoUsuarioRepository.save(suporteAoUsuario);
    }
    public Object SuportesResolvidosPorcentagem() {
        return suporteAoUsuarioRepository.SuportesResolvidosPorcentagem();
    }
}
