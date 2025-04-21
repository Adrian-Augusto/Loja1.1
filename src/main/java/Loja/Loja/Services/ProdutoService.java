package Loja.Loja.Services;

import Loja.Loja.Entity.Marca;
import Loja.Loja.Entity.Produto;
import Loja.Loja.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> searchAllProduct() {
        return produtoRepository.findAll();
    }
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }
    public Produto addProduto(Produto produto){
        return  produtoRepository.saveAndFlush(produto);

    }

}
