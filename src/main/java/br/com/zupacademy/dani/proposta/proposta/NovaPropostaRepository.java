package br.com.zupacademy.dani.proposta.proposta;

import br.com.zupacademy.dani.proposta.analisecartao.StatusRestricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NovaPropostaRepository extends JpaRepository <NovaProposta, Long> {

    Optional<NovaProposta> findByDocumento(String documento);

    List<Optional<NovaProposta>> findByStatusRestricaoAndCartao(StatusRestricao status, String cartao);
}