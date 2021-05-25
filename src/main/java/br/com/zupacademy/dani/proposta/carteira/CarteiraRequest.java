package br.com.zupacademy.dani.proposta.carteira;

import br.com.zupacademy.dani.proposta.cartao.Cartao;

import javax.validation.constraints.Email;

public class CarteiraRequest {

    @Email
    private String email;
    private CarteiraOpcao carteira = CarteiraOpcao.NAO_ASSOCIADO;

    public CarteiraRequest(String email, CarteiraOpcao carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraOpcao getCarteira() {
        return carteira;
    }

    public Carteira toModel(Cartao cartao) {
        return new Carteira(cartao, this.email);
    }
}
