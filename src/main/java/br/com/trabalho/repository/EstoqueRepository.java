package br.com.trabalho.repository;

import br.com.trabalho.banco.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    List<Estoque> findByLoja_id(Long loja_id);
}
