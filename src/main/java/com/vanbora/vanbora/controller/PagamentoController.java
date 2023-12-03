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

import com.vanbora.vanbora.models.Pagamento;
import com.vanbora.vanbora.services.PagamentoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/pagamento")
@Validated
public class PagamentoController{

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable("id") Long id) {
        Pagamento obj = this.pagamentoService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@Valid @RequestBody Pagamento pagamento) {
        this.pagamentoService.create(pagamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pagamento.getPagamentoID()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable("id") Long id, @Valid @RequestBody Pagamento pagamento) {
        pagamento.setPagamentoID(id);
        this.pagamentoService.update(pagamento);
        return ResponseEntity.noContent().build();
    }
}


