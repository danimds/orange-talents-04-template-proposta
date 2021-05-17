package br.com.zupacademy.dani.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository <Cartao, Long> {

    Optional<Cartao> findByNumero(String numero);
}
