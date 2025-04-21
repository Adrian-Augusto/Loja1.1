package Loja.Loja.Services;

import Loja.Loja.Entity.Pessoa;
import Loja.Loja.Repository.PessoaRepository;
import jakarta.persistence.Id;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    //BuscarPessoas//


    public List<Pessoa> buscarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaID(Long id){
        return pessoaRepository.findById(id);

    }

    public Pessoa insertPessoas(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoa1=  pessoaRepository.saveAndFlush(pessoa);
        return pessoa;

    }

    public Optional<Pessoa> updatePessoa(Long id, Pessoa novaPessoa) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoaExistente = pessoaOptional.get();
            pessoaExistente.setNome(novaPessoa.getNome());

            pessoaRepository.save(pessoaExistente);

        }

        return pessoaOptional;
    }

    public Optional<Pessoa> remove(Long id){
        Optional<Pessoa>pessoas= pessoaRepository.findById(id);
        pessoas.ifPresent(pessoaEncontrada-> pessoaRepository.existsById(id));
        return pessoas;
    }




    }



