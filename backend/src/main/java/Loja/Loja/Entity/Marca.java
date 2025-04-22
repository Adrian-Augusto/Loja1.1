package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;

    //Relacionamento

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
