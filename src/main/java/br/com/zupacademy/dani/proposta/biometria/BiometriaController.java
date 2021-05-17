package br.com.zupacademy.dani.proposta.biometria;


import br.com.zupacademy.dani.proposta.cartao.Cartao;
import br.com.zupacademy.dani.proposta.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    BiometriaRepository biometriaRepository;

    @PostMapping("/{numero}")
    public ResponseEntity<?> cadastraBiometria(@RequestBody @Valid BiometriaRequest request,
                                           @PathVariable("numero") String numero,
                                           UriComponentsBuilder uriComponentsBuilder){
        Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(numero);
        return possivelCartao.map(cartaoEncontrado -> {
            Biometria novaBiometria = request.toModel(cartaoEncontrado);
            biometriaRepository.save(novaBiometria);
            URI uriRetorno = uriComponentsBuilder.path("/biometria").build(novaBiometria.getId());
            return ResponseEntity.created(uriRetorno).build();
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
