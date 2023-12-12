package com.vanbora.vanbora.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "viagem")
public class Viagem {

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viagemid", unique = true)
    private Long viagemID;


    @Column(name = "data_viagem", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataViagem;

    @Column(name = "local_saida", length = 50, nullable = false)
    @NotBlank
    private String localSaida;
    

    @Column(name = "destino_final", length = 50, nullable = false)
    @NotBlank
    private String destinoFinal;
    

    @Column(name = "valor_viagem", nullable = false)
    @NotNull
    private Double valorViagem;
    

    @Column(name = "quantidade_de_passageiros", nullable = false)
    @NotNull
    private Integer quantidadeDePassageiros;
    

    @Column(name = "status_viagem", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'PENDENTE'" )
    @Size(min = 5 ,max = 20)
    private String statusViagem = "PENDENTE";

    @Column(name = "tipo_viagem", length = 20,nullable = false)
    @Size(min = 5 ,max = 20)
    @NotBlank
    private String tipoViagem;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "viagens_usuarios",
        joinColumns = @JoinColumn(name = "usuario_fk",updatable = true,nullable = true),
        inverseJoinColumns = @JoinColumn(name = "viagem_fk",updatable = true,nullable = true)
    )
    private Set<Usuario> usuarios;

    @ManyToOne(optional = true)
    @JoinColumn(name = "motoristacpf", referencedColumnName = "cpf", updatable = true,nullable = true)
    private Motorista motorista;

    
    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL)
    
    private List<AvaliacaoCorrida> avaliacoes ;
    
    // getters e setters


    

   
    

    
    
}
