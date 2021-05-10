package br.com.zupacademy.dani.proposta.repository;

import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovaPropostaRepository extends JpaRepository <NovaProposta, Long> {

}
