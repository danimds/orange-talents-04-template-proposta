package br.com.zupacademy.dani.proposta.cartao;

import br.com.zupacademy.dani.proposta.proposta.NovaProposta;
import br.com.zupacademy.dani.proposta.analisecartao.StatusRestricao;
import br.com.zupacademy.dani.proposta.proposta.NovaPropostaRepository;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class BuscaCartaoSchedule {

    @Autowired
    CartoesClient cartoesClient;

    @Autowired
    NovaPropostaRepository propostaRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        List<Optional<NovaProposta>> propostaLista = propostaRepository.findByStatusRestricaoAndCartao(StatusRestricao.ELEGIVEL, null);
        for (Optional<NovaProposta> possivelProposta : propostaLista) {
            salvaCartao(possivelProposta.get());
        }
    }

    private void salvaCartao(NovaProposta novaProposta) {
        CartaoRequest cartaoRequest = new CartaoRequest(novaProposta.getDocumento(), novaProposta.getNome(), novaProposta.getId().toString());
        try {
            CartaoResponse cartaoResponse = cartoesClient.retornoNumeroCartao(cartaoRequest);
            novaProposta.setCartao(cartaoResponse.getId());
            propostaRepository.save(novaProposta);
            Cartao cartao = new Cartao(novaProposta, cartaoResponse.getId(), cartaoResponse.getEmitidoEm());
            cartaoRepository.save(cartao);

        } catch (FeignException.BadRequest badRequest) {
            badRequest.printStackTrace();
        } catch (RetryableException r) {
            r.printStackTrace();
        } catch (FeignException.InternalServerError ex) {
                ex.printStackTrace();
        }
    }


}
