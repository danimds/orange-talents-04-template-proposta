package br.com.zupacademy.dani.proposta.proposta;

import br.com.zupacademy.dani.proposta.analisecartao.StatusRestricao;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class NovaProposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusRestricao statusRestricao;
    private String cartao;


    @Deprecated
    public NovaProposta() {
    }

    public NovaProposta(String documento, String nome, String email, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.email = email;;
        this.salario = salario;
        this.statusRestricao = StatusRestricao.NAO_ANALISADO;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setStatusRestricao(StatusRestricao statusRestricao) {
        this.statusRestricao = statusRestricao;
    }

    public StatusRestricao getStatusRestricao() {
        return statusRestricao;
    }

    public String getIdCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
}
