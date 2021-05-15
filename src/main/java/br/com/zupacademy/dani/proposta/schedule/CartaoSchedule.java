package br.com.zupacademy.dani.proposta.schedule;

import br.com.zupacademy.dani.proposta.clients.CartoesClient;
import br.com.zupacademy.dani.proposta.controller.response.CartaoResponse;
import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import br.com.zupacademy.dani.proposta.modelo.StatusRestricao;
import br.com.zupacademy.dani.proposta.repository.NovaPropostaRepository;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CartaoSchedule {

    @Autowired
    CartoesClient cartoesClient;

    @Autowired
    NovaPropostaRepository propostaRepository;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        List<Optional<NovaProposta>> propostaLista = propostaRepository.findByStatusRestricaoAndCartao(StatusRestricao.ELEGIVEL, null);
        for (Optional<NovaProposta> possivelProposta : propostaLista) {
            salvaCartao(possivelProposta.get());
        }
    }

    private void salvaCartao(NovaProposta novaProposta) {

        try {
            CartaoResponse cartao = cartoesClient.retornoNumeroCartao(novaProposta.getId().toString());
            novaProposta.setCartao(cartao.getId());
            propostaRepository.save(novaProposta);
        } catch (FeignException.BadRequest badRequest) {
            badRequest.printStackTrace();
        } catch (RetryableException r) {
            r.printStackTrace();
        } catch (FeignException.InternalServerError ex) {
                ex.printStackTrace();
        }

    }


}
