package br.com.zupacademy.dani.proposta.carteira;

public class CarteiraResponse {

    private String id;
    private CarteiraOpcao carteiraOpcao;
    private String email;

    @Deprecated
    public CarteiraResponse() {

    }

    public CarteiraResponse(Carteira carteira) {

        this.id = carteira.getId().toString();
        this.carteiraOpcao = carteira.carteiraOpcao;
        this.email = carteira.getEmail();
    }

    public String getId() {
        return id;
    }

    public CarteiraOpcao getCarteiraOpcao() {
        return carteiraOpcao;
    }

    public String getEmail() {
        return email;
    }


}
