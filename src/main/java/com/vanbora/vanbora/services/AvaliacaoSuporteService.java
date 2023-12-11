
package com.vanbora.vanbora.services;

import java.util.Optional;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbora.vanbora.repositories.AvaliacaoSuporteRepository;

import jakarta.transaction.Transactional;

import com.vanbora.vanbora.DTOs.ContagemEstrelasDTO;
import com.vanbora.vanbora.models.AvaliacaoSuporte;
import com.vanbora.vanbora.models.SuporteAoUsuario;
import com.vanbora.vanbora.models.Usuario;
@Service
public class AvaliacaoSuporteService {
    
    @Autowired
    private AvaliacaoSuporteRepository avaliacaoSuporteRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SuporteAoUsuarioService suporteAoUsuarioService;



    public AvaliacaoSuporte findById(Long id) {
        Optional<AvaliacaoSuporte> avaliacaoSuporte = this.avaliacaoSuporteRepository.findById(id);
        return avaliacaoSuporte.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + AvaliacaoSuporte.class.getName()));
        
}
    @Transactional
    public AvaliacaoSuporte create(AvaliacaoSuporte avaliacaoSuporte) {
        avaliacaoSuporte.setAvaliacaoID(null);
        

        return avaliacaoSuporteRepository.save(avaliacaoSuporte);
    }
    public ContagemEstrelasDTO contarEstrelas() {
        return avaliacaoSuporteRepository.contarEstrelas();
    }


}
