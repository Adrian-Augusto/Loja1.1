package Loja.Loja.Services;

import Loja.Loja.Entity.Estado;
import Loja.Loja.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    // Buscar todos os estados
    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    // Buscar estado por ID
    public Optional<Estado> searchCityID(Long id) {
        return estadoRepository.findById(id);
    }

    public Estado insertCity(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }
    // Atualizar um estado existente

    public Estado updateCity(Estado estado, Long id) {
        Optional<Estado> estadoExistente = estadoRepository.findById(estado.getId());

        if (estadoExistente.isPresent()) {
            Estado atual = estadoExistente.get();
            atual.setNome(estado.getNome());
            atual.setSigla(estado.getSigla());
            atual.setDataAtualizacao(new Date());

            return estadoRepository.save(atual);
        } else {
            throw new RuntimeException("Estado não encontrado com ID: " + estado.getId());
            }}

    //REMOVENTO CIDADE//

    public Optional<Estado> deleteEstado(Long id){
        Optional<Estado> estado1= estadoRepository.findById(id);
        estado1.ifPresent(estadoRepository::delete);
        return estado1;

    }}