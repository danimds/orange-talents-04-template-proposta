package br.com.zupacademy.dani.proposta.controller;

import br.com.zupacademy.dani.proposta.controller.request.NovaPropostaRequest;
import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zupacademy.dani.proposta.repository.NovaPropostaRepository;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

    @Autowired
    private NovaPropostaRepository novaPropostaRepository;

//    @Autowired
//    private ProibeCpfOrCnpjDuplicadoValidator proibeCpfOrCnpjDuplicadoValidator;
//
//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.addValidators(proibeCpfOrCnpjDuplicadoValidator);
//
//    }

    @PostMapping
    public ResponseEntity<String> cadastrarNovaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriBuilder) {

        Optional<NovaProposta> resultado = novaPropostaRepository.findByDocumento(request.getDocumento());
        return resultado
                .map(propostaExistente -> {
                    return ResponseEntity.status(422).body("Proposta já existe no sistema");
                })
                .orElseGet(() -> {
                    NovaProposta novaProposta = request.toModel();
                    novaPropostaRepository.save(novaProposta);
                    URI uri = uriBuilder.path("/novaProposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
                    //return ResponseEntity.created(uri).body(new NovaPropostaResponse(novaProposta));
                    return ResponseEntity.created(uri).build();
                });
    }
}
