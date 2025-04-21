package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    LocalDateTime DataCriacao;
    LocalDateTime  DataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @OneToMany(mappedBy = "Pessoas")
    private List<Pessoa> pessoas;

}
