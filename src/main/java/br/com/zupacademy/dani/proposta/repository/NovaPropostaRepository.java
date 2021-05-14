package br.com.zupacademy.dani.proposta.repository;

import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import br.com.zupacademy.dani.proposta.modelo.StatusRestricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface NovaPropostaRepository extends JpaRepository <NovaProposta, Long> {

    Optional<NovaProposta> findByDocumento(String documento);

    List<Optional<NovaProposta>> findByStatusRestricaoAndCartao(StatusRestricao status, String cartao);

}
