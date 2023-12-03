    package com.vanbora.vanbora.models;

    import jakarta.persistence.*;

    import jakarta.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


    @Entity
    @Table(name = "avaliacao_corrida")
    public class AvaliacaoCorrida {
        

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "avaliacaoid",unique = true)
        private Long avaliacaoID;

        @Column(name = "comentario", columnDefinition = "TEXT", nullable = false)
        private String comentario;
        
        @Column(name = "estrelas")
        private Integer estrelas;

        @ManyToOne(optional = true)
        @JoinColumn(name = "usuariocpf", referencedColumnName = "cpf", nullable = false, updatable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Usuario usuario;

        @ManyToOne(optional = true)
        @JoinColumn(name = "motoristacpf", referencedColumnName = "cpf", nullable = false, updatable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Motorista motorista;

        @ManyToOne(optional = true)
        @JoinColumn(name = "viagemid", referencedColumnName = "viagemid", nullable = false, updatable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Viagem viagem;

        // getters e setters

    public AvaliacaoCorrida() {
    }

    public AvaliacaoCorrida(Long avaliacaoID, String comentario, Integer estrelas, Usuario usuario, Motorista motorista, Viagem viagem) {
        this.avaliacaoID = avaliacaoID;
        this.comentario = comentario;
        this.usuario = usuario;
        this.motorista = motorista;
        this.viagem = viagem;
        this.estrelas = estrelas;
    }

    public Long getAvaliacaoID() {
        return this.avaliacaoID;
    }

    public void setAvaliacaoID(Long avaliacaoID) {
        this.avaliacaoID = avaliacaoID;
    }


    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Integer getEstrelas() {
        return this.estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Viagem getViagem() {
        return this.viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public AvaliacaoCorrida avaliacaoID(Long avaliacaoID) {
        setAvaliacaoID(avaliacaoID);
        return this;
    }


    public AvaliacaoCorrida comentario(String comentario) {
        setComentario(comentario);
        return this;
    }
    public AvaliacaoCorrida estrelas(Integer estrelas) {
        setEstrelas(estrelas);
        return this;
    }

    public AvaliacaoCorrida usuario(Usuario usuario) {
        setUsuario(usuario);
        return this;
    }

    public AvaliacaoCorrida motorista(Motorista motorista) {
        setMotorista(motorista);
        return this;
    }

    public AvaliacaoCorrida viagem(Viagem viagem) {
        setViagem(viagem);
        return this;
    }

   


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AvaliacaoCorrida)) {
            return false;
        }
        AvaliacaoCorrida avaliacaoCorrida = (AvaliacaoCorrida) o;
        return Objects.equals(avaliacaoID, avaliacaoCorrida.avaliacaoID) && Objects.equals(comentario, avaliacaoCorrida.comentario) && Objects.equals(estrelas, avaliacaoCorrida.estrelas) && Objects.equals(usuario, avaliacaoCorrida.usuario) && Objects.equals(motorista, avaliacaoCorrida.motorista) && Objects.equals(viagem, avaliacaoCorrida.viagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avaliacaoID, comentario, estrelas, usuario, motorista, viagem);
    }
     
   

    


        
        
    }

