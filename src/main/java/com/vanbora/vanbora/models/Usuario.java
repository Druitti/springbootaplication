package com.vanbora.vanbora.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
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

    @ManyToMany(mappedBy = "usuarios",fetch = FetchType.EAGER)
    private Set<Viagem> viagens;
   
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<AvaliacaoCorrida> avaliacoesCorrida = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL )
    private List<SuporteAoUsuario> suportesAoUsuario = new ArrayList<>();

    
  
    
    

   

    

    
}
