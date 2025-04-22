package Loja.Loja.Services;

import Loja.Loja.Entity.Pessoa;
import Loja.Loja.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaDetailService {


    @Autowired
    PessoaRepository pessoaRepository;



    public Pessoa buscarPorEmail(String email) {
        return pessoaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o email: " + email));


    }

}
