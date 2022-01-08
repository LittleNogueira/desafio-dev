package br.com.bycoders.desafiodev.repositories;

import br.com.bycoders.desafiodev.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
