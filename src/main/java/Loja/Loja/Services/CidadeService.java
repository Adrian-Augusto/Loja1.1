package Loja.Loja.Services;

import Loja.Loja.Entity.Cidade;
import Loja.Loja.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService{

    @Autowired
    private CidadeRepository cidadeRepository;

    // Buscar todas as cidades
    public List<Cidade> buscarTodas() {
        return cidadeRepository.findAll();
    }

    // Buscar cidade por ID
    public Optional<Cidade> buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id);
    }

    // Inserir cidade
    public Cidade inserirCidade(Cidade cidade) {
        cidade.setDataCriacao(LocalDateTime.now());
        return cidadeRepository.save(cidade);
    }

    // Atualizar cidade
    public Cidade atualizarCidade(Cidade cidade) {
        Optional<Cidade> cidadeExistente = cidadeRepository.findById(cidade.getId());

        if (cidadeExistente.isPresent()) {
            Cidade atual = cidadeExistente.get();
            atual.setNome(cidade.getNome());
            atual.setEstado(cidade.getEstado());
            atual.setDataAtualizacao(LocalDateTime.now());

            return cidadeRepository.save(atual);
        } else {
            throw new RuntimeException("Cidade não encontrada com ID: " + cidade.getId());
        }
    }

    // Deletar cidade
    public Optional<Cidade> deletarCidade(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        cidade.ifPresent(cidadeRepository::delete);
        return cidade;
    }
}
