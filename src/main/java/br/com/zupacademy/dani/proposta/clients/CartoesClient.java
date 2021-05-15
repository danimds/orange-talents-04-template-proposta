package br.com.zupacademy.dani.proposta.clients;

import br.com.zupacademy.dani.proposta.controller.response.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "cartoes", url = "${cartao.host}")
@Component
public interface CartoesClient {

    @RequestMapping(method = RequestMethod.GET)
    public CartaoResponse retornoNumeroCartao(@RequestParam("idProposta") String idProposta);

}
