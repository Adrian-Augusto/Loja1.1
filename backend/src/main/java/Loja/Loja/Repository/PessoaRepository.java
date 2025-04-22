package Loja.Loja.Repository;

import Loja.Loja.Entity.Pessoa;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa,Long> {
    Optional<Pessoa> findByEmail(String email);

}
