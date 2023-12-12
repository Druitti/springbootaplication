package com.vanbora.vanbora.controller;

import java.net.URI;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vanbora.vanbora.DTOs.ContagemAvgPsgViagDTO;
import com.vanbora.vanbora.DTOs.TipoViagemDTO;
import com.vanbora.vanbora.models.Viagem;
 import com.vanbora.vanbora.services.ViagemService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/viagem")
@Validated
public class ViagemController {
    
    @Autowired
    private ViagemService viagemService;


    

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> findById(@PathVariable("id") Long id) {
        Viagem obj = this.viagemService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Viagem> create(@Valid @RequestBody Viagem viagem) {
        this.viagemService.create(viagem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagem.getViagemID()).toUri();
        return ResponseEntity.created(uri).build();                     
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> update ( @Valid @RequestBody Viagem viagem, @PathVariable("id") Long id) {
        
        viagem.setViagemID(id);
        this.viagemService.update(viagem);
        return ResponseEntity.noContent().build();
       
    }

    @GetMapping("/passageirosPorFaixa")
    public ResponseEntity<ContagemAvgPsgViagDTO> getMediaPorFaixa() {
        ContagemAvgPsgViagDTO obj = this.viagemService.calcularMediaPorFaixa();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/percentual")
    public ResponseEntity<TipoViagemDTO> getPercentuais() {
        TipoViagemDTO obj = this.viagemService.calcularPercentuais();
        return ResponseEntity.ok(obj);
    }
    

    
    






}
