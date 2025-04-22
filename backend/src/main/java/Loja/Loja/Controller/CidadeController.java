package Loja.Loja.Controller;

import Loja.Loja.Entity.Cidade;
import Loja.Loja.Services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public List<Cidade> listarTodos() {
        return cidadeService.buscarCidadesTodas();
    }

    @GetMapping("/{id}")
    public Optional<Cidade> buscarPorId(@PathVariable Long id) {
        return cidadeService.buscarCidadePorId(id);
    }

    @PostMapping
    public Cidade adicionar(@RequestBody Cidade cidade) {
        return cidadeService.inserirCidade(cidade);
    }

    @PutMapping("/{id}")
    public Cidade atualizar(@PathVariable Long id, @RequestBody Cidade cidade) {
        return cidadeService.atualizarCidade(cidade);
    }

    @DeleteMapping("/{id}")
    public Optional<Cidade> remover(@PathVariable Long id) {
        return cidadeService.deletarCidade(id);
    }
}