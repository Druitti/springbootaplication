package com.vanbora.vanbora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbora.vanbora.repositories.PagamentoRepository;

import com.vanbora.vanbora.repositories.ViagemRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;
import com.vanbora.vanbora.models.Pagamento;

@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;


    /*public Pagamento findById(Long id) {
        Optional<Pagamento> pagamento = this.pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
    }*/
    public Pagamento findById(Long id) {
        Optional<Pagamento> pagamento = this.pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
    }

    @Transactional
    public Pagamento create(Pagamento pagamento) {
        
        pagamento.setPagamentoID(null);
        return this.pagamentoRepository.save(pagamento);

    }
    @Transactional

    public Pagamento update(Pagamento pagamento){
        Pagamento novPagamento = this.findById(pagamento.getPagamentoID());
        novPagamento.setValorPagamento(pagamento.getValorPagamento());
        novPagamento.setStatusPagamento(pagamento.getStatusPagamento());
        return this.pagamentoRepository.save(novPagamento);


    }

}

