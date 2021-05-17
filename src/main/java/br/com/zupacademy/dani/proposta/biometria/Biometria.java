package br.com.zupacademy.dani.proposta.biometria;

import br.com.zupacademy.dani.proposta.cartao.Cartao;

import javax.persistence.*;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    private String fingerPrint;


    /**
     *  @deprecated (apenas para o hibernate)
     */
    @Deprecated
    public Biometria() {
    }

    public Biometria(Cartao cartao, String fingerPrint) {
        this.cartao = cartao;
        this.fingerPrint = fingerPrint;
    }

    public Long getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }
}
