package com.vanbora.vanbora.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vanbora.vanbora.models.AvaliacaoCorrida;
import com.vanbora.vanbora.services.AvaliacaoCorridaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacaoCorrida")
@Validated
public class AvaliacaoCorridaController {
    
    @Autowired
    private AvaliacaoCorridaService avaliacaoCorridaService;

    @GetMapping("/{id}")

    public ResponseEntity<AvaliacaoCorrida> findById(@PathVariable("id") Long id) {
        AvaliacaoCorrida obj = this.avaliacaoCorridaService.findById(id);
        return ResponseEntity.ok(obj);
    }



    @PostMapping

    public ResponseEntity<AvaliacaoCorrida> create(@Valid @RequestBody AvaliacaoCorrida avaliacaoCorrida) {
        this.avaliacaoCorridaService.create(avaliacaoCorrida);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacaoCorrida.getAvaliacaoID()).toUri();
        return ResponseEntity.created(uri).build();
    }

    


}
