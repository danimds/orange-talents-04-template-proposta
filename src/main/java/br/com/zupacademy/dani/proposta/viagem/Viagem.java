package br.com.zupacademy.dani.proposta.viagem;

import br.com.zupacademy.dani.proposta.cartao.Cartao;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String destino;
    private LocalDate dataTermino;
    private LocalDateTime instante = LocalDateTime.now();
    private String ipCliente;
    private String agenteDoUsuario;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Cartao cartao;

    @Deprecated
    public Viagem() {
    }


    public Viagem(Cartao cartao, String destino, LocalDate dataTermino, String ipCliente, String userAgent) {
        this.destino = destino;
        this.dataTermino = dataTermino;
        this.ipCliente = ipCliente;
        this.agenteDoUsuario = userAgent;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public String getDestinoViagem() {
        return destino;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getAgenteDoUsuario() {
        return agenteDoUsuario;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
