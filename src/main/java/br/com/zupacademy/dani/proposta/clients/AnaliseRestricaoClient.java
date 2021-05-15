package br.com.zupacademy.dani.proposta.clients;


import br.com.zupacademy.dani.proposta.controller.request.AnaliseRestricaoRequest;
import br.com.zupacademy.dani.proposta.controller.response.AnaliseRestricaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "solicitacao", url = "${analises.host}")
@Component
public interface AnaliseRestricaoClient {

    @RequestMapping(method = RequestMethod.POST)
    public AnaliseRestricaoResponse analisaRestricao(AnaliseRestricaoRequest request);

}
