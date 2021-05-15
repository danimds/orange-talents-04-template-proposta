package br.com.zupacademy.dani.proposta.controller;

import br.com.zupacademy.dani.proposta.clients.AnaliseRestricaoClient;
import br.com.zupacademy.dani.proposta.controller.request.AnaliseRestricaoRequest;
import br.com.zupacademy.dani.proposta.controller.request.NovaPropostaRequest;
import br.com.zupacademy.dani.proposta.controller.response.AnaliseRestricaoResponse;
import br.com.zupacademy.dani.proposta.controller.response.NovaPropostaResponse;
import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import br.com.zupacademy.dani.proposta.modelo.RetornoRestricao;
import br.com.zupacademy.dani.proposta.modelo.StatusRestricao;
import br.com.zupacademy.dani.proposta.repository.NovaPropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

    @Autowired
    private NovaPropostaRepository novaPropostaRepository;

    @Autowired
    AnaliseRestricaoClient analiseRestricaoClient;

    @PostMapping
    public ResponseEntity<String> cadastrarNovaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriBuilder) {

        Optional<NovaProposta> resultado = novaPropostaRepository.findByDocumento(request.getDocumento());
        return resultado
                .map(propostaExistente -> {
                    return ResponseEntity.status(422).body("Proposta já existe no sistema");
                })
                .orElseGet(() -> {
                    NovaProposta novaProposta = request.toModel();

                    analisaRestricao(novaProposta);
                    novaPropostaRepository.save(novaProposta);
                    URI uri = uriBuilder.path("/novaProposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
                    //return ResponseEntity.created(uri).body(new NovaPropostaResponse(novaProposta));
                    return ResponseEntity.created(uri).build();
                });
    }

    private void analisaRestricao(NovaProposta novaProposta) {
        StatusRestricao status;
        try {
            AnaliseRestricaoResponse respostaCpf = analiseRestricaoClient.analisaRestricao(new AnaliseRestricaoRequest(novaProposta));
            assert respostaCpf.getResultadoSolicitacao().equals(RetornoRestricao.SEM_RESTRICAO);
            status = StatusRestricao.ELEGIVEL;
        } catch (FeignException.UnprocessableEntity e) {
            status = StatusRestricao.NAO_ELEGIVEL;
        }
        novaProposta.setStatusRestricao(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NovaPropostaResponse> detalhar(@PathVariable Long id) {
        Optional<NovaProposta> existeProposta = novaPropostaRepository.findById(id);
        if (existeProposta.isPresent()) {
            return ResponseEntity.ok(new NovaPropostaResponse(existeProposta.get()));
        }
        return ResponseEntity.notFound().build();

    }

}
