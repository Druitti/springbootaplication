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

import com.vanbora.vanbora.models.Motorista;
import com.vanbora.vanbora.services.MotoristaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/motorista")
@Validated
public class MotoristaController {

@Autowired
private MotoristaService motoristaService;

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> findById(@PathVariable("id") Long motoristaID) {
        Motorista obj = this.motoristaService.findById(motoristaID);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Motorista> create(@Valid @RequestBody Motorista motorista) {
        this.motoristaService.create(motorista);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(motorista.getCPF()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Motorista> update(@PathVariable("id") Long motoristaID, @Valid @RequestBody Motorista motorista) {
        motorista.setCPF(motoristaID);
        this.motoristaService.update(motorista);
        return ResponseEntity.noContent().build();
    }
}
