package com.vanbora.vanbora.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vanbora.vanbora.models.Usuario;
import com.vanbora.vanbora.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController{

        @Autowired
        private UsuarioService usuarioService; 

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
            Usuario obj = this.usuarioService.findById(id);
            return ResponseEntity.ok(obj);
        }

        @PostMapping
        public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
            this.usuarioService.create(usuario);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getCpf()).toUri();
            return ResponseEntity.created(uri).build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
            usuario.setCpf(id);
            this.usuarioService.update(usuario);
            return ResponseEntity.noContent().build();
        }




        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
            this.usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        }

}