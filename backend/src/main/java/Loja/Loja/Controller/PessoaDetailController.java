package Loja.Loja.Controller;

import Loja.Loja.Entity.Pessoa;
import Loja.Loja.Services.PessoaDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-detalhes")
@CrossOrigin
public class PessoaDetailController {

    @Autowired
    private PessoaDetailService pessoaDetailService;

    @GetMapping("/email/{email}")
    public Pessoa buscarPorEmail(@PathVariable String email) {
        return pessoaDetailService.buscarPorEmail(email);
    }
}