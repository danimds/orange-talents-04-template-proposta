package br.com.zupacademy.dani.proposta.proposta;

import br.com.zupacademy.dani.proposta.analisecartao.StatusRestricao;

import java.math.BigDecimal;

public class NovaPropostaResponse {

    private Long id;
    private String documento;
    private String nome;
    private String email;
    private String endereco;
    private BigDecimal salario;
    private StatusRestricao statusRestricao;

    public NovaPropostaResponse(NovaProposta novaProposta) {

        this.id = novaProposta.getId();
        this.documento = novaProposta.getDocumento();
        this.nome = novaProposta.getNome();
        this.email = novaProposta.getEmail();
        this.endereco = novaProposta.getEndereco();
        this.salario = novaProposta.getSalario();
        this.statusRestricao = novaProposta.getStatusRestricao();
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

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusRestricao getStatusRestricao() {
        return statusRestricao;
    }
}

