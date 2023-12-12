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

import com.vanbora.vanbora.models.SuporteAoUsuario;

import com.vanbora.vanbora.services.SuporteAoUsuarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/suporte")
@Validated

public class SuporteController {
    
    @Autowired
    private SuporteAoUsuarioService suporteAoUsuarioService;


    @GetMapping("/{id}")
    public ResponseEntity<SuporteAoUsuario> findById(@PathVariable("id") Long id) {
        SuporteAoUsuario obj = this.suporteAoUsuarioService.findById(id);
        return ResponseEntity.ok(obj);
    }
    
    @PostMapping
    public ResponseEntity<SuporteAoUsuario> create(@Valid @RequestBody SuporteAoUsuario suporteAoUsuario) {
        this.suporteAoUsuarioService.create(suporteAoUsuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(suporteAoUsuario.getTicketID()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping("/percentual")
    public ResponseEntity<Object> SuportesResolvidosPorcentagem() {
        Object obj = this.suporteAoUsuarioService.SuportesResolvidosPorcentagem();
        return ResponseEntity.ok(obj);
    }
}
