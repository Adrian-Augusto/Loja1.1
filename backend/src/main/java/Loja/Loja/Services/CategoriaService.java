package Loja.Loja.Services;

import Loja.Loja.Entity.Categoria;
import Loja.Loja.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;  // Importação de LocalDateTime
import java.util.List;  // Importação necessária para List
import java.util.Optional;  // Importação necessária para Optional

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria objeto) {
        objeto.setDataCriacao(LocalDateTime.now());  // Usando LocalDateTime.now() ao invés de Date()
        Categoria objetoNovo = categoriaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Categoria alterar(Categoria objeto) {
        objeto.setDataAtualizacao(LocalDateTime.now());  // Usando LocalDateTime.now() ao invés de Date()
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Categoria objeto = categoriaRepository.findById(id).get();
        categoriaRepository.delete(objeto);
    }
}
