package br.com.trabalho.repository;

import br.com.trabalho.banco.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Cargo findByNome(String nome);
}
