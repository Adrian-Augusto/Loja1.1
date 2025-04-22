package Loja.Loja.Controller;

import Loja.Loja.Entity.Permissao;
import Loja.Loja.Services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissoes")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<Permissao> listarTodos() {
        return permissaoService.buscarPermissao();
    }

    @GetMapping("/{id}")
    public Optional<Permissao> buscarPorId(@PathVariable Long id) {
        return permissaoService.buscarPermissaoID(id);
    }

    @PostMapping
    public Permissao adicionar(@RequestBody Permissao permissao) {
        return permissaoService.insertPermissao(permissao);
    }

    @PutMapping("/{id}")
    public Optional<Permissao> atualizar(@PathVariable Long id, @RequestBody Permissao permissao) {
        return permissaoService.updatePermissao(id, permissao);
    }
}