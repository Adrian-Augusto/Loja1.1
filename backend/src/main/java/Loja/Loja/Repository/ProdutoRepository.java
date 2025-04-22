package Loja.Loja.Repository;

import Loja.Loja.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto,Long>{
}
