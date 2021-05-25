package br.com.zupacademy.dani.proposta.carteira;


import br.com.zupacademy.dani.proposta.cartao.Cartao;
import br.com.zupacademy.dani.proposta.cartao.CartaoRepository;
import br.com.zupacademy.dani.proposta.cartao.CartoesClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired
    private CartoesClient cartoesClient;

    @Autowired
    private CartaoRepository cartaoRepository;

    public ResponseEntity<?> associarCarteira(@PathVariable @NotNull Long id, UriComponentsBuilder uriBuilder,
                                              @RequestBody @Valid CarteiraRequest request) {

        Optional<Cartao> procuraCartao = cartaoRepository.findById(id);
        Cartao cartao = procuraCartao.get();

        try {
            cartoesClient.retornaSituacaoCarteira(cartao.getNumero(), request);
        } catch (FeignException e) {
            if (e.status() == 422)
                return ResponseEntity.unprocessableEntity().build();
            else
                throw e;
        }

        Carteira carteira = request.toModel(cartao);
        if (procuraCartao.isPresent()) {

            carteiraRepository.save(carteira);
            try {
                carteira.setCarteiraOpcao(CarteiraOpcao.ASSOCIADO);
                carteiraRepository.save(carteira);

            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
            URI uri = uriBuilder.path("/carteira/{id}").buildAndExpand(procuraCartao.get().getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        return ResponseEntity.notFound().build();

    }

}



