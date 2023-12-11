

package com.vanbora.vanbora.services;
import java.util.Optional;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbora.vanbora.DTOs.ContagemEstrelasDTO;
import com.vanbora.vanbora.models.AvaliacaoCorrida;
import com.vanbora.vanbora.models.Usuario;
import com.vanbora.vanbora.repositories.AvaliacaoCorridaRepository;

import jakarta.transaction.Transactional;



@Service
public class AvaliacaoCorridaService {
    
    @Autowired
    private AvaliacaoCorridaRepository avaliacaoCorridaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private ViagemService viagemService;

  
    

   public AvaliacaoCorrida findById(Long id) {
        
    Optional<AvaliacaoCorrida> avaliacaoCorrida = this.avaliacaoCorridaRepository.findById(id);
    return avaliacaoCorrida.orElseThrow(() -> new RuntimeException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + AvaliacaoCorrida.class.getName()));
    }   

    @Transactional
    public AvaliacaoCorrida create(AvaliacaoCorrida avaliacaoCorrida) {
        
        avaliacaoCorrida.setAvaliacaoID(null);
        return avaliacaoCorridaRepository.save(avaliacaoCorrida);
    }
    public ContagemEstrelasDTO contarEstrelas() {
        return avaliacaoCorridaRepository.contarEstrelas();
    }



    
    // Add other methods and functionality to the class as needed
}
