package br.com.zupacademy.dani.proposta.bloqueio;

import br.com.zupacademy.dani.proposta.cartao.Cartao;
import br.com.zupacademy.dani.proposta.cartao.CartaoRepository;
import br.com.zupacademy.dani.proposta.cartao.CartoesClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@RestController
@RequestMapping("/bloqueioCartao")
public class BloqueioController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    CartoesClient cartaoClient;

    @PostMapping("/{id}")
    public ResponseEntity<?> bloquearCartao(@PathVariable("id") Long idCartao, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest servletRequest) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(idCartao);
        return possivelCartao.map(cartaoEncontrado -> {
            if (cartaoEncontrado.bloqueado()) {
                return ResponseEntity.unprocessableEntity().body("Cartão já bloqueado.");
            }

            Boolean sistemaBancario = notificaSistemaBancario(cartaoEncontrado.getNumero());
            if (!sistemaBancario)
                return ResponseEntity.badRequest().body("API retornou erro");

            Bloqueio novoBloqueio = new Bloqueio(servletRequest.getRemoteAddr(), userAgent, cartaoEncontrado);
            cartaoEncontrado.setBloqueio(novoBloqueio);
            cartaoRepository.save(cartaoEncontrado);
            return ResponseEntity.ok().body("Cartão bloqueado");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Boolean notificaSistemaBancario(String numeroCartao) {
        try {
            BloqueioFeignResponse bloqueioResponse = cartaoClient.retornaSituacaoCartaoBloqueado(numeroCartao, new BloqueioFeignRequest("Proposta API"));
            return bloqueioResponse.bloqueado();
        } catch (FeignException.UnprocessableEntity erro) {
            return false;
        }
    }
}