package Loja.Loja.Services;

import Loja.Loja.Entity.Imagem;
import Loja.Loja.Repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    // Método para buscar todas as imagens
    public List<Imagem> searchAllImages() {
        return imagemRepository.findAll();
    }

    // Método para buscar imagem por ID
    public Imagem findImagemById(Long id) {
        return imagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagem não encontrada com ID: " + id));
    }

    // Método para adicionar uma imagem
    public Imagem addImagem(Imagem imagem) {
        return imagemRepository.saveAndFlush(imagem);
    }

    // Método para atualizar imagem
    public Optional<Imagem> updateImagem(Long id, Imagem imagem) {
        Optional<Imagem> imagemOptional = imagemRepository.findById(id);

        if (imagemOptional.isPresent()) {
            Imagem imagemExistente = imagemOptional.get();
            imagemExistente.setNome(imagem.getNome());

            imagemRepository.save(imagemExistente);
            return Optional.of(imagemExistente);
        }

        return Optional.empty();
    }

    // Diretório para salvar as imagens
    private static final String UPLOAD_DIR = "uploads/";

    // Método para fazer o upload da imagem
    public String uploadImage(MultipartFile file) {
        if (file.isEmpty()) {
            return "Nenhuma imagem foi enviada.";
        }

        try {
            // Cria o diretório de upload se não existir
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Caminho onde a imagem será salva
            File dest = new File(UPLOAD_DIR + file.getOriginalFilename());

            // Salva o arquivo no caminho especificado
            file.transferTo(dest);
            return "Imagem salva com sucesso! Caminho: " + dest.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar a imagem.";
        }
    }
}
