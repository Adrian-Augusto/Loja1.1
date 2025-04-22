package Loja.Loja.Services;

import Loja.Loja.Entity.Marca;
import Loja.Loja.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MarcaSerice {

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> buscarmarca() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> buscarmarca(Long id){
        return marcaRepository.findById(id);

    }


    public Marca addMarca(Marca marca){
      return  marcaRepository.saveAndFlush(marca);

    }


}
