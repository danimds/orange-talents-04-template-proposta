package br.com.zupacademy.dani.proposta.controller.request;

import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class AnaliseRestricaoRequest {

    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotNull
    private Long idProposta;

    public AnaliseRestricaoRequest(NovaProposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}
