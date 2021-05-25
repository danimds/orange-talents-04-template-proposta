package br.com.zupacademy.dani.proposta.cartao;

import br.com.zupacademy.dani.proposta.bloqueio.BloqueioFeignRequest;
import br.com.zupacademy.dani.proposta.bloqueio.BloqueioFeignResponse;
import br.com.zupacademy.dani.proposta.carteira.CarteiraRequest;
import br.com.zupacademy.dani.proposta.carteira.CarteiraResponse;
import br.com.zupacademy.dani.proposta.viagem.ViagemRequest;
import br.com.zupacademy.dani.proposta.viagem.ViagemResponse;
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

    @PostMapping(value = "/{id}/avisos", produces  = "application/json")
    public ViagemResponse retornaStatusAviso(@PathVariable("id") String id, @RequestBody ViagemRequest viagemResquest);

    @PostMapping(value = "/{id}/carteiras", produces  = "application/json")
    public CarteiraResponse retornaSituacaoCarteira(@PathVariable("id") String id, @RequestBody CarteiraRequest carteiraRequest);
}

