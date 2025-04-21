package Loja.Loja.Controller;

import Loja.Loja.Entity.Estado;
import Loja.Loja.Services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listarTodos() {
        return estadoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Estado> buscarPorId(@PathVariable Long id) {
        return estadoService.searchCityID(id);
    }

    @PostMapping
    public Estado adicionar(@RequestBody Estado estado) {
        return estadoService.insertCity(estado);
    }

    @PutMapping("/{id}")
    public Estado atualizar(@PathVariable Long id, @RequestBody Estado estado) {
        return estadoService.updateCity(estado, id);
    }

    @DeleteMapping("/{id}")
    public Optional<Estado> remover(@PathVariable Long id) {
        return estadoService.deleteEstado(id);
    }
}
