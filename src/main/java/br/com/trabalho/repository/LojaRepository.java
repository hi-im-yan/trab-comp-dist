package br.com.trabalho.repository;

import br.com.trabalho.banco.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
}
