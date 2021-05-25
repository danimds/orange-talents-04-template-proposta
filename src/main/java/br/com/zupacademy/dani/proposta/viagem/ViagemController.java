package br.com.zupacademy.dani.proposta.viagem;

import br.com.zupacademy.dani.proposta.cartao.Cartao;
import br.com.zupacademy.dani.proposta.cartao.CartaoRepository;
import br.com.zupacademy.dani.proposta.cartao.CartoesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartoesClient cartoesClient;

    @Autowired
    private ViagemRepository viagemRepository;

    @PostMapping("/{id}")
    public ResponseEntity avisarViagem(@PathVariable("id") Long idCartao, @RequestBody @Valid ViagemRequest viagemRequest,
                                       HttpServletRequest request) {

        Optional<Cartao> procuraCartao = cartaoRepository.findById(idCartao);
        if (procuraCartao.isPresent()) {
            Cartao cartao = procuraCartao.get();

            if (viagemRequest.dataMaiorQueHoje(viagemRequest.getDataTermino()) == true) {
                try {
                    cartoesClient.retornaStatusAviso(cartao.getNumero(), viagemRequest);
                    viagemRequest.setIpCliente(request.getRemoteAddr());
                    viagemRequest.setUserAgent(request.getHeader("User-Agent"));
                    Viagem viagem = viagemRequest.toModel(procuraCartao.get());
                    viagemRepository.save(viagem);
                    return ResponseEntity.ok().build();

                } catch (Exception e) {
                    return ResponseEntity.badRequest().build();
                }

            } else return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();

    }
}

