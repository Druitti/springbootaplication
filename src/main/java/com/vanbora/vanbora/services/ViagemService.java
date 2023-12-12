package com.vanbora.vanbora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbora.vanbora.DTOs.ContagemAvgPsgViagDTO;
import com.vanbora.vanbora.models.Viagem;
import com.vanbora.vanbora.repositories.UsuarioRepository;
import com.vanbora.vanbora.repositories.ViagemRepository;

import jakarta.transaction.Transactional;
@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;
    
    @Autowired
    private MotoristaService motoristaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    public Viagem findById(Long id){
        Optional<Viagem> viagem = this.viagemRepository.findById(id);
        return viagem.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Viagem.class.getName()));
    }
    @Transactional
    public Viagem create(Viagem viagem){
        

        viagem.setViagemID(null);
        
       
        return viagemRepository.save(viagem);
    }
    @Transactional
    public Viagem update(Viagem viagem){
        Viagem novaViagem = findById(viagem.getViagemID());
        novaViagem.setAvaliacoes(viagem.getAvaliacoes());
        novaViagem.setStatusViagem(viagem.getStatusViagem());
        novaViagem.setQuantidadeDePassageiros(viagem.getQuantidadeDePassageiros());
        novaViagem.setUsuarios(viagem.getUsuarios());
        novaViagem.setMotorista(viagem.getMotorista());

        return viagemRepository.save(novaViagem);

    }
    
    public ContagemAvgPsgViagDTO calcularMediaPorFaixa(){
        return viagemRepository.calcularMediaPorFaixa();
    }

}
