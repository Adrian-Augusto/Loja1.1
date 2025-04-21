package Loja.Loja.Controller;

import Loja.Loja.Entity.Marca;
import Loja.Loja.Services.MarcaSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin
public class MarcaController {

    @Autowired
    private MarcaSerice marcaService;

    @GetMapping
    public List<Marca> listarTodos() {
        return marcaService.buscarmarca();
    }

    @GetMapping("/{id}")
    public Optional<Marca> buscarPorId(@PathVariable Long id) {
        return marcaService.buscarmarca(id);
    }

    @PostMapping
    public Marca adicionar(@RequestBody Marca marca) {
        return marcaService.addMarca(marca);
    }
}