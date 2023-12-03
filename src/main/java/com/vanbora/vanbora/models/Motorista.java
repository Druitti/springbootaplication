package com.vanbora.vanbora.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@Entity
@Table(name = "motorista")
public class Motorista {
    
    @Id
    @Column(name = "cpf", unique = true)
    @NotNull
    private Long cpf;

    @Column(name ="nome", nullable = false, length = 30)
    @Size(min = 5 , max = 30)
    @NotBlank
    private String nome;

    @Column(name = "conta_bancaria", nullable = false, unique = true ) 
    @NotNull
    private Long contaBancaria;

    @Column(name = "carro_placa",length = 7,nullable = false, unique = true)
    @Size(min = 1 , max = 7)
    @NotNull
    private String carroPlaca;


    @Column(name = "numero_cnh", nullable = false, unique = true)
    @NotNull
    private Integer NumeroCNH;


/*     @Column(name = "CNH")
    @NotEmpty
    @NotNull

    private Integer CNH; */


   /*  @Column(name = "DataValidadeCNH")
    @NotEmpty
    @NotNull


    private Date DataValidadeCNH;
 */
/* 
    @Column(name = "DataCertificacaoCNH")
    @NotEmpty
    @NotEmpty

    private Date DataCertificacaoCNH; */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Viagem> viagens = new ArrayList<>();
    
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<AvaliacaoCorrida> avaliacoesCorrida = new ArrayList<>();

   
    //getters e setters


    


   

    

    public Motorista() {
    }

    public Motorista(Long cpf, String nome, Long contaBancaria, String carroPlaca, Integer NumeroCNH /* Integer CNH, Date DataValidadeCNH, Date DataCertificacaoCNH, */ /* List<Viagem> viagens, List<AvaliacaoCorrida> avaliacoesCorrida */ ) {
        this.cpf = cpf;
        this.nome = nome;
        this.contaBancaria = contaBancaria;
        this.carroPlaca = carroPlaca;
        this.NumeroCNH = NumeroCNH;
        /* this.CNH = CNH;
        this.DataValidadeCNH = DataValidadeCNH;
        this.DataCertificacaoCNH = DataCertificacaoCNH; */
        /* this.viagens = viagens;
        this.avaliacoesCorrida = avaliacoesCorrida; */
       
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

    public Long getContaBancaria() {
        return this.contaBancaria;
    }

    public void setContaBancaria(Long contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getCarroPlaca() {
        return this.carroPlaca;
    }

    public void setCarroPlaca(String carroPlaca) {
        this.carroPlaca = carroPlaca;
    }

    public Integer getNumeroCNH() {
        return this.NumeroCNH;
    }

    public void setNumeroCNH(Integer NumeroCNH) {
        this.NumeroCNH = NumeroCNH;
    }

   /*  public Integer getCNH() {
        return this.CNH;
    }

    public void setCNH(Integer CNH) {
        this.CNH = CNH;
    }

    public Date getDataValidadeCNH() {
        return this.DataValidadeCNH;
    }

    public void setDataValidadeCNH(Date DataValidadeCNH) {
        this.DataValidadeCNH = DataValidadeCNH;
    }

    public Date getDataCertificacaoCNH() {
        return this.DataCertificacaoCNH;
    }

    public void setDataCertificacaoCNH(Date DataCertificacaoCNH) {
        this.DataCertificacaoCNH = DataCertificacaoCNH;
    }
 */
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

    

    public Motorista cpf(Long cpf) {
        setCPF(cpf);
        return this;
    }

    public Motorista nome(String nome) {
        setNome(nome);
        return this;
    }

    public Motorista contaBancaria(Long contaBancaria) {
        setContaBancaria(contaBancaria);
        return this;
    }

    public Motorista carroPlaca(String carroPlaca) {
        setCarroPlaca(carroPlaca);
        return this;
    }

    public Motorista NumeroCNH(Integer NumeroCNH) {
        setNumeroCNH(NumeroCNH);
        return this;
    }

   /*  public Motorista CNH(Integer CNH) {
        setCNH(CNH);
        return this;
    }

    public Motorista DataValidadeCNH(Date DataValidadeCNH) {
        setDataValidadeCNH(DataValidadeCNH);
        return this;
    }

    public Motorista DataCertificacaoCNH(Date DataCertificacaoCNH) {
        setDataCertificacaoCNH(DataCertificacaoCNH);
        return this;
    } */

  /*   public Motorista viagens(List<Viagem> viagens) {
        setViagens(viagens);
        return this;
    }

    public Motorista avaliacoesCorrida(List<AvaliacaoCorrida> avaliacoesCorrida) {
        setAvaliacoesCorrida(avaliacoesCorrida);
        return this;
    } */

    

 /*    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Motorista)) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return cpf == motorista.cpf && Objects.equals(nome, motorista.nome) && contaBancaria == motorista.contaBancaria && Objects.equals(carroPlaca, motorista.carroPlaca) && NumeroCNH == motorista.NumeroCNH && CNH == motorista.CNH && Objects.equals(DataValidadeCNH, motorista.DataValidadeCNH) && Objects.equals(DataCertificacaoCNH, motorista.DataCertificacaoCNH) && Objects.equals(viagens, motorista.viagens) && Objects.equals(avaliacoesCorrida, motorista.avaliacoesCorrida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, contaBancaria, carroPlaca, NumeroCNH, CNH, DataValidadeCNH, DataCertificacaoCNH, viagens, avaliacoesCorrida);
    
}
 */

}
