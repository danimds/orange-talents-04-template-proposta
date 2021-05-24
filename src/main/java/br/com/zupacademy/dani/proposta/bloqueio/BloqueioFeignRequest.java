package br.com.zupacademy.dani.proposta.bloqueio;

public class BloqueioFeignRequest {

    private String sistemaResponsavel;

    public BloqueioFeignRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
