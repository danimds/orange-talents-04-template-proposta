package br.com.zupacademy.dani.proposta.carteira;


import br.com.zupacademy.dani.proposta.cartao.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = { CascadeType.ALL })
    public Cartao cartao;
    @Email
    @NotBlank
    private String email;
    @Enumerated(EnumType.STRING)
    public CarteiraOpcao carteiraOpcao;

    @Deprecated
    public Carteira() {
    }

    public Carteira(Cartao cartao, String email, CarteiraOpcao carteiraOpcao) {
        this.cartao = cartao;
        this.email = email;
        this.carteiraOpcao = carteiraOpcao;
    }

    public Long getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraOpcao getCarteiraOpcao() {
        return carteiraOpcao;
    }

    public void setCarteiraOpcao(CarteiraOpcao carteiraOpcao) {
        this.carteiraOpcao = carteiraOpcao;
    }
}
