package br.com.zupacademy.dani.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cartoes", url = "${cartao.host}")
@Component
public interface CartoesClient {

    @PostMapping
    CartaoResponse retornoNumeroCartao(@RequestBody CartaoRequest request);

}
