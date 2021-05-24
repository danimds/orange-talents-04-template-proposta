package br.com.zupacademy.dani.proposta.viagem;

import br.com.zupacademy.dani.proposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ViagemRequest {
    @NotBlank
    private String destino;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataTermino;
    private String ipCliente;
    private String userAgent;

    public ViagemRequest(String destino, Date dataTermino, String ipCliente, String userAgent) {
        this.destino = destino;
        this.dataTermino = dataTermino;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Viagem toModel(Cartao cartao) {
        return new Viagem(cartao, destino, dataTermino, ipCliente, userAgent);
    }
}
