package br.com.zupacademy.dani.proposta.cartao;

import java.time.LocalDateTime;

public class CartaoResponse {

    private String id;

    private LocalDateTime emitidoEm;

    @Deprecated
    public CartaoResponse(){
    }

    public CartaoResponse(String id, LocalDateTime emitidoEm) {
        this.id = id;
        this.emitidoEm = emitidoEm;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }
}
