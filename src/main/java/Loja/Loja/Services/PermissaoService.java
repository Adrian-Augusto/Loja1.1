package Loja.Loja.Services;

import Loja.Loja.Entity.Permissao;
import Loja.Loja.Repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

    @Autowired
    PermissaoRepository permissaoRepository;

    public List<Permissao> buscarPermissao() {
        return permissaoRepository.findAll();
    }

    public Optional<Permissao> buscarPermissaoID(Long id) {
        return permissaoRepository.findById(id);
    }

    public Permissao insertPermissao(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        // Salvando a permissão e retornando o objeto salvo, já com os dados do banco.
        return permissaoRepository.saveAndFlush(permissao);
    }

    public Optional<Permissao> updatePermissao(Long id, Permissao permissao) {
        return permissaoRepository.findById(id).map(permissaoExistente -> {
            // Atualizando os campos com os valores da permissão recebida
            permissaoExistente.setNome(permissao.getNome());
            permissaoExistente.setEmail(permissao.getEmail());
            permissaoExistente.setEndereco(permissao.getEndereco());
            permissaoExistente.setCep(permissao.getCep());
            permissaoExistente.setCidade(permissao.getCidade());
            permissaoExistente.setDataAtualizacao(new Date());

            // Salvando a permissão atualizada
            permissaoRepository.save(permissaoExistente);
            return permissaoExistente;
        });
    }
}
