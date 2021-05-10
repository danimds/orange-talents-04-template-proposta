package br.com.zupacademy.dani.proposta.controller;

import br.com.zupacademy.dani.proposta.controller.request.NovaPropostaRequest;
import br.com.zupacademy.dani.proposta.controller.response.NovaPropostaResponse;
import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zupacademy.dani.proposta.repository.NovaPropostaRepository;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

    @Autowired
    private NovaPropostaRepository novaPropostaRepository;

    @PostMapping
    public ResponseEntity<NovaPropostaResponse> cadastrarNovaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriBuilder) {
        NovaProposta novaProposta = request.toModel();
        novaPropostaRepository.save(novaProposta);
        URI uri = uriBuilder.path("/novaProposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new NovaPropostaResponse(novaProposta));
    }
}
