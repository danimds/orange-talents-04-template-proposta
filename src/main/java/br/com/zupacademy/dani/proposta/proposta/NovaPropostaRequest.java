package br.com.zupacademy.dani.proposta.proposta;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaRequest {

    @NotBlank
    @CPForCNPJ
    private String documento;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotNull
    @Positive(message = "Valor do salário é inválido")
    private BigDecimal salario;


    public NovaPropostaRequest(String documento, String nome, String email, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.salario = salario;
    }

    public NovaProposta toModel () {
        return new NovaProposta(this.documento, this.nome, this.email, this.endereco, this.salario);
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() { return nome; }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
