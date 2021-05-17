package br.com.zupacademy.dani.proposta.cartao;

import br.com.zupacademy.dani.proposta.biometria.Biometria;
import br.com.zupacademy.dani.proposta.proposta.NovaProposta;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne @JoinColumn(name = "proposta")
    private NovaProposta proposta;
    private String numero;
    @NotNull
    private LocalDateTime emitidoEm;
    @OneToMany(mappedBy = "cartao")
    private Set<Biometria> biometrias;


    public Cartao() {
    }

    public Cartao(NovaProposta proposta, String numeroCartao, LocalDateTime emitidoEm){
        this.proposta = proposta;
        this.numero = numeroCartao;
        this.emitidoEm = emitidoEm;
    }

    public Long getId() {
        return id;
    }

    public NovaProposta getProposta() {
        return proposta;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }
}
