package com.vanbora.vanbora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.vanbora.vanbora.models.Motorista;
 import com.vanbora.vanbora.repositories.AvaliacaoCorridaRepository;

import com.vanbora.vanbora.repositories.MotoristaRepository;
import com.vanbora.vanbora.repositories.ViagemRepository;

import jakarta.transaction.Transactional;
@Service
public class MotoristaService {


    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private AvaliacaoCorridaRepository avaliacaoCorridaRepository;

    @Autowired
    private ViagemRepository viagemRepository; 

    

    public Motorista findById(Long cpf){
        Optional<Motorista> motorista = this.motoristaRepository.findById(cpf);
        return motorista.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + cpf + ", Tipo: " + Motorista.class.getName()));
    }

    
    @Transactional
    public Motorista create(Motorista motorista){
        
        return this.motoristaRepository.save(motorista);
    }
    
    
    @Transactional
    public Motorista update(Motorista motorista){
        Motorista newMotorista = findById(motorista.getCPF());
        newMotorista.setCarroPlaca(motorista.getCarroPlaca());
        newMotorista.setContaBancaria(motorista.getContaBancaria());
         newMotorista.setNumeroCNH(motorista.getNumeroCNH()); 
        

        return motoristaRepository.save(newMotorista);
    }
    
}
