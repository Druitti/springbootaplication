package com.vanbora.vanbora.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vanbora.vanbora.DTOs.ContagemEstrelasDTO;
import com.vanbora.vanbora.models.AvaliacaoSuporte;
import com.vanbora.vanbora.services.AvaliacaoSuporteService;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/avaliacaoSuporte")
@Validated
public class AvaliacaoSuporteController {
    @Autowired
    private AvaliacaoSuporteService avaliacaoSuporteService;

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoSuporte> findById(@PathVariable("id") Long id) {
        AvaliacaoSuporte obj = this.avaliacaoSuporteService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoSuporte> create(@Valid @RequestBody AvaliacaoSuporte avaliacaoSuporte) {
        this.avaliacaoSuporteService.create(avaliacaoSuporte);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacaoSuporte.getAvaliacaoID()).toUri();
        return ResponseEntity.created(uri).build();
        
    }
    @GetMapping("/estrelas")
    public ResponseEntity<ContagemEstrelasDTO> contarEstrelas() {
        ContagemEstrelasDTO obj = this.avaliacaoSuporteService.contarEstrelas();
        return ResponseEntity.ok(obj);
    }



}
