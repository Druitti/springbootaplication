package com.vanbora.vanbora.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;





@Entity
@Table(name = "usuario")
public class Usuario {
    

    @Id
    @Column(name = "cpf", unique = true)
    @NotNull
    private Long cpf;

    @Column(name = "nome", nullable = false, length = 30)
    @Size(min = 5, max = 30)
    @NotBlank
    private String nome;


    @Column(name = "email", length = 40)
    @Size( min = 2, max = 40)
    @NotBlank
    private String email;

    @Column(name = "metodo_pagamento", length = 15, columnDefinition = "VARCHAR(15) DEFAULT 'DINHEIRO'")
    @Size(min = 3, max = 15)
    @NotBlank
    private String metodoPagamento = "DINHEIRO";

   @ManyToMany
    @JoinTable(
        name = "viagem_usuario",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "viagem_id")
    )
    private List<Viagem> viagens;
   
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<AvaliacaoCorrida> avaliacoesCorrida = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL )
    private List<SuporteAoUsuario> suportesAoUsuario = new ArrayList<>();

    
  

    

   

    public Usuario() {
    }

    public Usuario(Long cpf, String nome, String email, String metodoPagamento, List<Viagem> viagens, List<AvaliacaoCorrida> avaliacoesCorrida, List<SuporteAoUsuario> suportesAoUsuario ) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.metodoPagamento = metodoPagamento;
        this.viagens = viagens;
        this.avaliacoesCorrida = avaliacoesCorrida;
        this.suportesAoUsuario = suportesAoUsuario;
        
    }

    public Long getCPF() {
        return this.cpf;
    }

    public void setCPF(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public List<Viagem> getViagens() {
        return this.viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public List<AvaliacaoCorrida> getAvaliacoesCorrida() {
        return this.avaliacoesCorrida;
    }

    public void setAvaliacoesCorrida(List<AvaliacaoCorrida> avaliacoesCorrida) {
        this.avaliacoesCorrida = avaliacoesCorrida;
    }

    public List<SuporteAoUsuario> getSuportesAoUsuario() {
        return this.suportesAoUsuario;
    }

    public void setSuportesAoUsuario(List<SuporteAoUsuario> suportesAoUsuario) {
        this.suportesAoUsuario = suportesAoUsuario;
    }

    

    

    public Usuario cpf(Long cpf) {
        setCPF(cpf);
        return this;
    }

    public Usuario nome(String nome) {
        setNome(nome);
        return this;
    }

    public Usuario email(String email) {
        setEmail(email);
        return this;
    }

    public Usuario metodoPagamento(String metodoPagamento) {
        setMetodoPagamento(metodoPagamento);
        return this;
    }

    public Usuario viagens(List<Viagem> viagens) {
        setViagens(viagens);
        return this;
    }

    public Usuario avaliacoesCorrida(List<AvaliacaoCorrida> avaliacoesCorrida) {
        setAvaliacoesCorrida(avaliacoesCorrida);
        return this;
    }

    public Usuario suportesAoUsuario(List<SuporteAoUsuario> suportesAoUsuario) {
        setSuportesAoUsuario(suportesAoUsuario);
        return this;
    }

    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return cpf == usuario.cpf && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(metodoPagamento, usuario.metodoPagamento) && Objects.equals(viagens, usuario.viagens) && Objects.equals(avaliacoesCorrida, usuario.avaliacoesCorrida) && Objects.equals(suportesAoUsuario, usuario.suportesAoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, email, metodoPagamento, viagens, avaliacoesCorrida, suportesAoUsuario);
    }

   

   
    

    
}
