package br.com.zupacademy.dani.proposta.biometria;

import br.com.zupacademy.dani.proposta.cartao.Cartao;

import java.util.Base64;

public class BiometriaRequest {

    private String fingerPrint;

    @Deprecated
    public BiometriaRequest() {
    }

    public BiometriaRequest(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public String converteParaBase64() {
        return Base64.getEncoder().encodeToString(fingerPrint.getBytes());
    }

    public Biometria toModel(Cartao cartao) {
        return new Biometria(cartao, converteParaBase64());
    }
}

