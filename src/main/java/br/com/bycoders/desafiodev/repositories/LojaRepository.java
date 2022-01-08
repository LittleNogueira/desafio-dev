package br.com.bycoders.desafiodev.repositories;

import br.com.bycoders.desafiodev.entities.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, String> {
}
