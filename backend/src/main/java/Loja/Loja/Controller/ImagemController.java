package Loja.Loja.Controller;

import Loja.Loja.Entity.Imagem;
import Loja.Loja.Services.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagens")
@CrossOrigin
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    @GetMapping
    public List<Imagem> listarTodos() {
        return imagemService.searchAllImages();
    }

    @GetMapping("/{id}")
    public Imagem buscarPorId(@PathVariable Long id) {
        return imagemService.findImagemById(id);
    }

    @PostMapping
    public Imagem adicionar(@RequestBody Imagem imagem) {
        return imagemService.addImagem(imagem);
    }

    @PutMapping("/{id}")
    public Optional<Imagem> atualizar(@PathVariable Long id, @RequestBody Imagem imagem) {
        return imagemService.updateImagem(id, imagem);
    }

    @PostMapping("/upload")
    public String uploadImagem(@RequestParam("file") MultipartFile file) {
        return imagemService.uploadImage(file);
    }
}
