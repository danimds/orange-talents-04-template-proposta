package br.com.zupacademy.dani.proposta.controller.response;

import br.com.zupacademy.dani.proposta.modelo.NovaProposta;

import java.math.BigDecimal;

public class NovaPropostaResponse {

    private Long id;
    private String documento;
    private String nome;
    private String email;
    private String endereço;
    private BigDecimal salario;

    public NovaPropostaResponse(NovaProposta novaProposta) {

        this.id = novaProposta.getId();
        this.documento = novaProposta.getDocumento();
        this.nome = novaProposta.getNome();
        this.email = novaProposta.getEmail();
        this.endereço = novaProposta.getEndereço();
        this.salario = novaProposta.getSalario();
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereço() {
        return endereço;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}

