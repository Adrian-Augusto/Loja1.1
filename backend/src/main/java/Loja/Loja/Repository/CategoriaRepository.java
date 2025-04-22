package Loja.Loja.Repository;

import Loja.Loja.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria,Long> {
}
