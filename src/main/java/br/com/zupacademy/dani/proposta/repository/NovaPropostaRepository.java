package br.com.zupacademy.dani.proposta.repository;

import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NovaPropostaRepository extends JpaRepository <NovaProposta, Long> {

    Optional<NovaProposta> findByDocumento(String documento);
}
