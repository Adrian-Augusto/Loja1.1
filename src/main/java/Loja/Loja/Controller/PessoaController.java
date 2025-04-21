package Loja.Loja.Controller;

import Loja.Loja.Entity.Pessoa;
import Loja.Loja.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Buscar todas as pessoas
    @GetMapping("/")
    public ResponseEntity<List<Pessoa>> buscarPessoas() {
        List<Pessoa> pessoas = pessoaService.buscarPessoas();
        if (pessoas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoas);
    }

    // Inserir nova pessoa
    @PostMapping("/")
    public ResponseEntity<Pessoa> insertPessoas(@RequestBody Pessoa objeto) {
        Pessoa novaPessoa = pessoaService.insertPessoas(objeto);
        return ResponseEntity.ok(novaPessoa);
    }

    // Atualizar pessoa
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoa objeto) {
        return pessoaService.updatePessoa(id, objeto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Remover pessoa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        pessoaService.remove(id);
        return ResponseEntity.ok().build();
    }
}
