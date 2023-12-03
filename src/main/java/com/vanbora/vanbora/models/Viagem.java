package com.vanbora.vanbora.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;



@Entity
@Table(name = "viagem")
public class Viagem {

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viagemid", unique = true)
    private Long viagemID;

    /* @Column(name = "usuariocpf",insertable = false , updatable = false, nullable = false,unique = true)
    @NotNull
    private Long usuarioCPF;

    @Column(name = "motoristacpf",insertable = false , updatable = false, nullable = false,unique = true)
    @NotNull
    private Long motoristaCPF; */


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

    
    @ManyToMany(mappedBy = "viagens",fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    @ManyToOne(optional = true)
    @JoinColumn(name = "motoristacpf", referencedColumnName = "cpf", updatable = false)
    private Motorista motorista;

    
    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL)
    
    private List<AvaliacaoCorrida> avaliacoes = new ArrayList<>();
    
    // getters e setters


    

    public Viagem() {
    }

    public Viagem(Long viagemID, LocalDate dataViagem, String localSaida, String destinoFinal, Double valorViagem, Integer quantidadeDePassageiros, String statusViagem, String tipoViagem, List<Usuario> usuarios, Motorista motorista, List<AvaliacaoCorrida> avaliacoes) {
        this.viagemID = viagemID;
        this.dataViagem = dataViagem;
        this.localSaida = localSaida;
        this.destinoFinal = destinoFinal;
        this.valorViagem = valorViagem;
        this.quantidadeDePassageiros = quantidadeDePassageiros;
        this.statusViagem = statusViagem;
        this.tipoViagem = tipoViagem;
        this.usuarios = usuarios;
        this.motorista = motorista;
        this.avaliacoes = avaliacoes;
    }

    public Long getViagemID() {
        return this.viagemID;
    }

    public void setViagemID(Long viagemID) {
        this.viagemID = viagemID;
    }

    public LocalDate getDataViagem() {
        return this.dataViagem;
    }

    public void setDataViagem(LocalDate dataViagem) {
        this.dataViagem = dataViagem;
    }

    public String getLocalSaida() {
        return this.localSaida;
    }

    public void setLocalSaida(String localSaida) {
        this.localSaida = localSaida;
    }

    public String getDestinoFinal() {
        return this.destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public Double getValorViagem() {
        return this.valorViagem;
    }

    public void setValorViagem(Double valorViagem) {
        this.valorViagem = valorViagem;
    }

    public Integer getQuantidadeDePassageiros() {
        return this.quantidadeDePassageiros;
    }

    public void setQuantidadeDePassageiros(Integer quantidadeDePassageiros) {
        this.quantidadeDePassageiros = quantidadeDePassageiros;
    }

    public String getStatusViagem() {
        return this.statusViagem;
    }

    public void setStatusViagem(String statusViagem) {
        this.statusViagem = statusViagem;
    }

    public String getTipoViagem() {
        return this.tipoViagem;
    }

    public void setTipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<AvaliacaoCorrida> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoCorrida> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Viagem viagemID(Long viagemID) {
        setViagemID(viagemID);
        return this;
    }

    public Viagem dataViagem(LocalDate dataViagem) {
        setDataViagem(dataViagem);
        return this;
    }

    public Viagem localSaida(String localSaida) {
        setLocalSaida(localSaida);
        return this;
    }

    public Viagem destinoFinal(String destinoFinal) {
        setDestinoFinal(destinoFinal);
        return this;
    }

    public Viagem valorViagem(Double valorViagem) {
        setValorViagem(valorViagem);
        return this;
    }

    public Viagem quantidadeDePassageiros(Integer quantidadeDePassageiros) {
        setQuantidadeDePassageiros(quantidadeDePassageiros);
        return this;
    }

    public Viagem statusViagem(String statusViagem) {
        setStatusViagem(statusViagem);
        return this;
    }

    public Viagem tipoViagem(String tipoViagem) {
        setTipoViagem(tipoViagem);
        return this;
    }

    public Viagem usuarios(List<Usuario> usuarios) {
        setUsuarios(usuarios);
        return this;
    }

    public Viagem motorista(Motorista motorista) {
        setMotorista(motorista);
        return this;
    }

    public Viagem avaliacoes(List<AvaliacaoCorrida> avaliacoes) {
        setAvaliacoes(avaliacoes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Viagem)) {
            return false;
        }
        Viagem viagem = (Viagem) o;
        return Objects.equals(viagemID, viagem.viagemID) && Objects.equals(dataViagem, viagem.dataViagem) && Objects.equals(localSaida, viagem.localSaida) && Objects.equals(destinoFinal, viagem.destinoFinal) && Objects.equals(valorViagem, viagem.valorViagem) && Objects.equals(quantidadeDePassageiros, viagem.quantidadeDePassageiros) && Objects.equals(statusViagem, viagem.statusViagem) && Objects.equals(tipoViagem, viagem.tipoViagem) && Objects.equals(usuarios, viagem.usuarios) && Objects.equals(motorista, viagem.motorista) && Objects.equals(avaliacoes, viagem.avaliacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viagemID, dataViagem, localSaida, destinoFinal, valorViagem, quantidadeDePassageiros, statusViagem, tipoViagem, usuarios, motorista, avaliacoes);
    }

    

    
    
}
