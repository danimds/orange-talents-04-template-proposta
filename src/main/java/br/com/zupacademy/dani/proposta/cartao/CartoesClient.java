package br.com.zupacademy.dani.proposta.cartao;

import br.com.zupacademy.dani.proposta.bloqueio.BloqueioFeignRequest;
import br.com.zupacademy.dani.proposta.bloqueio.BloqueioFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cartoes", url = "${cartao.host}")
@Component
public interface CartoesClient {

    @PostMapping
    CartaoResponse retornoNumeroCartao(@RequestBody CartaoRequest request);

    @PostMapping (value = "/{id}/bloqueios", produces  = "application/json")
    public BloqueioFeignResponse retornaSituacaoCartaoBloqueado(@PathVariable("id") String numeroCartao, @RequestBody BloqueioFeignRequest bloqueioRequest);
}
