package br.com.zupacademy.dani.proposta.clients;


import br.com.zupacademy.dani.proposta.controller.request.AnaliseRestricaoRequest;
import br.com.zupacademy.dani.proposta.controller.response.AnaliseRestricaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "solicitacao", url = "http://127.0.0.1:9999/api")
@Component
public interface AnaliseRestricaoCliente {

    @RequestMapping(method = RequestMethod.POST, value = "/solicitacao")
    public AnaliseRestricaoResponse analisaRestricao(AnaliseRestricaoRequest request);

}
