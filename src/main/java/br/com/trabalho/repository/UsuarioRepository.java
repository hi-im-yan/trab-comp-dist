package br.com.trabalho.repository;

import br.com.trabalho.banco.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
