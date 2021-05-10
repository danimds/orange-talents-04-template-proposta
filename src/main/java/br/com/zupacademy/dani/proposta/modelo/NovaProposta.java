package br.com.zupacademy.dani.proposta.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class NovaProposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documento;
    private String nome;
    private String email;
    private String endereço;
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
