package br.com.trabalho.repository;

import br.com.trabalho.banco.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaItemRepository extends JpaRepository<VendaItem, Long> {
}
