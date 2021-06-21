package br.com.trabalho.repository;

import br.com.trabalho.banco.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
