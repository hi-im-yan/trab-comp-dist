package br.com.trabalho.repository;

import br.com.trabalho.banco.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
