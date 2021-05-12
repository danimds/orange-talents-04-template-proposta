package br.com.zupacademy.dani.proposta.modelo;


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
    @Column(unique=true)
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String endereço;
    @NotNull
    @Positive
    private BigDecimal salario;

    @Deprecated
    public NovaProposta() {
    }

    public NovaProposta(String documento, String nome, String email, String endereço, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.salario = salario;
    }


    public Long getId() { return id; }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
