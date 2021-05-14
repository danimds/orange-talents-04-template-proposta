package br.com.zupacademy.dani.proposta.controller.response;

public class CartaoResponse {

    private String id;

    @Deprecated
    public CartaoResponse(){


    }

    public CartaoResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
