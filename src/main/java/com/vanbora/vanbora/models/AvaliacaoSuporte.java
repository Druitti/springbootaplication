package com.vanbora.vanbora.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


@Entity
@Table(name = "avaliacao_suporte")



public class AvaliacaoSuporte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avaliacaoid", unique = true)
    private Long avaliacaoID;


    @Column(name = "estrelas")
    private Integer estrelas;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @OneToOne
    @JoinColumn(name = "usuariocpf", referencedColumnName = "cpf", nullable = false, updatable = false)
    @NotNull
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "ticketid", referencedColumnName = "ticketid", nullable = false, updatable = false)
    @NotNull
    private SuporteAoUsuario suporteAoUsuario;

    // getters e setters


    public AvaliacaoSuporte() {
    }

    public AvaliacaoSuporte(Long avaliacaoID, Integer estrelas, String comentario, Usuario usuario, SuporteAoUsuario suporteAoUsuario) {
        this.avaliacaoID = avaliacaoID;
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.usuario = usuario;
        this.suporteAoUsuario = suporteAoUsuario;
    }

    public Long getAvaliacaoID() {
        return this.avaliacaoID;
    }

    public void setAvaliacaoID(Long avaliacaoID) {
        this.avaliacaoID = avaliacaoID;
    }

    

    public Integer getEstrelas() {
        return this.estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SuporteAoUsuario getSuporteAoUsuario() {
        return this.suporteAoUsuario;
    }

    public void setSuporteAoUsuario(SuporteAoUsuario suporteAoUsuario) {
        this.suporteAoUsuario = suporteAoUsuario;
    }

    public AvaliacaoSuporte avaliacaoID(Long avaliacaoID) {
        setAvaliacaoID(avaliacaoID);
        return this;
    }


    public AvaliacaoSuporte estrelas(Integer estrelas) {
        setEstrelas(estrelas);
        return this;
    }

    public AvaliacaoSuporte comentario(String comentario) {
        setComentario(comentario);
        return this;
    }

    public AvaliacaoSuporte usuario(Usuario usuario) {
        setUsuario(usuario);
        return this;
    }

    public AvaliacaoSuporte suporteAoUsuario(SuporteAoUsuario suporteAoUsuario) {
        setSuporteAoUsuario(suporteAoUsuario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AvaliacaoSuporte)) {
            return false;
        }
        AvaliacaoSuporte avaliacaoSuporte = (AvaliacaoSuporte) o;
        return avaliacaoID == avaliacaoSuporte.avaliacaoID && estrelas == avaliacaoSuporte.estrelas && Objects.equals(comentario, avaliacaoSuporte.comentario) && Objects.equals(usuario, avaliacaoSuporte.usuario) && Objects.equals(suporteAoUsuario, avaliacaoSuporte.suporteAoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avaliacaoID, estrelas, comentario, usuario, suporteAoUsuario);
    }

   
   

}
