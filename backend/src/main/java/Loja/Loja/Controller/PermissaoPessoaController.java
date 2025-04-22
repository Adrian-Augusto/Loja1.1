package Loja.Loja.Controller;

import Loja.Loja.Services.PermissaoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permissao-pessoas")
public class PermissaoPessoaController {

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;


}