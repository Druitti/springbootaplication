





    package com.vanbora.vanbora.models;

    import jakarta.persistence.*;






    import java.util.Objects;

    import com.fasterxml.jackson.annotation.JsonProperty;
    @Entity
    @Table(name = "suporte_ao_usuario")
    public class SuporteAoUsuario {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ticketid",unique = true)
        private Long ticketID;


        @Column(name = "status_solicitacao", length = 15, columnDefinition = "VARCHAR(15) DEFAULT 'PENDENTE'")
        private String statusSolicitacao = "PENDENTE";

        @Column(name = "responsavel", length = 30)
        
        private String responsavel;

        @ManyToOne(optional = true)
        @JoinColumn(name = "usuariocpf", referencedColumnName = "cpf" ,  nullable = false, updatable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Usuario usuario;

        // getters e setters


        public SuporteAoUsuario() {
        }

        public SuporteAoUsuario(Long ticketID, String statusSolicitacao, String responsavel, Usuario usuario) {
            this.ticketID = ticketID;
            this.statusSolicitacao = statusSolicitacao;
            this.responsavel = responsavel;
            this.usuario = usuario;
        }

        public Long getTicketID() {
            return this.ticketID;
        }

        public void setTicketID(Long ticketID) {
            this.ticketID = ticketID;
        }

        public String getStatusSolicitacao() {
            return this.statusSolicitacao;
        }

        public void setStatusSolicitacao(String statusSolicitacao) {
            this.statusSolicitacao = statusSolicitacao;
        }

        public String getResponsavel() {
            return this.responsavel;
        }

        public void setResponsavel(String responsavel) {
            this.responsavel = responsavel;
        }

        public Usuario getUsuario() {
            return this.usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public SuporteAoUsuario ticketID(Long ticketID) {
            setTicketID(ticketID);
            return this;
        }

        public SuporteAoUsuario statusSolicitacao(String statusSolicitacao) {
            setStatusSolicitacao(statusSolicitacao);
            return this;
        }

        public SuporteAoUsuario responsavel(String responsavel) {
            setResponsavel(responsavel);
            return this;
        }

        public SuporteAoUsuario usuario(Usuario usuario) {
            setUsuario(usuario);
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof SuporteAoUsuario)) {
                return false;
            }
            SuporteAoUsuario suporteAoUsuario = (SuporteAoUsuario) o;
            return Objects.equals(ticketID, suporteAoUsuario.ticketID) && Objects.equals(statusSolicitacao, suporteAoUsuario.statusSolicitacao) && Objects.equals(responsavel, suporteAoUsuario.responsavel) && Objects.equals(usuario, suporteAoUsuario.usuario);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ticketID, statusSolicitacao, responsavel, usuario);
        }

        @Override
        public String toString() {
            return "{" +
                " ticketID='" + getTicketID() + "'" +
                ", statusSolicitacao='" + getStatusSolicitacao() + "'" +
                ", responsavel='" + getResponsavel() + "'" +
                ", usuario='" + getUsuario() + "'" +
                "}";
        }

        
        
    }
    