package com.vanbora.vanbora.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;


import java.util.Objects;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamentoid", unique = true)
    
    private Long pagamentoID;

    @Column(name = "valor_pagamento")
    @NotNull
    private Double valorPagamento;

    @Column(name = "status_pagamento", columnDefinition = "VARCHAR(15) DEFAULT 'PENDENTE'")
    private String statusPagamento="PENDENTE";
    

    
    @OneToOne
    @JoinColumn(name = "viagemid", referencedColumnName = "viagemid", nullable = false, updatable = false)
    private Viagem viagem;

    // getters e setters

    


    

   
  

 

    


    public Pagamento() {
    }

    public Pagamento(Long pagamentoID, Double valorPagamento, String statusPagamento, Viagem viagem) {
        this.pagamentoID = pagamentoID;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
        this.viagem = viagem;
    }

    public Long getPagamentoID() {
        return this.pagamentoID;
    }

    public void setPagamentoID(Long pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public Double getValorPagamento() {
        return this.valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getStatusPagamento() {
        return this.statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Viagem getViagem() {
        return this.viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Pagamento pagamentoID(Long pagamentoID) {
        setPagamentoID(pagamentoID);
        return this;
    }

    public Pagamento valorPagamento(Double valorPagamento) {
        setValorPagamento(valorPagamento);
        return this;
    }

    public Pagamento statusPagamento(String statusPagamento) {
        setStatusPagamento(statusPagamento);
        return this;
    }

    public Pagamento viagem(Viagem viagem) {
        setViagem(viagem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pagamento)) {
            return false;
        }
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(pagamentoID, pagamento.pagamentoID) && Objects.equals(valorPagamento, pagamento.valorPagamento) && Objects.equals(statusPagamento, pagamento.statusPagamento) && Objects.equals(viagem, pagamento.viagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagamentoID, valorPagamento, statusPagamento, viagem);
    }

   

}