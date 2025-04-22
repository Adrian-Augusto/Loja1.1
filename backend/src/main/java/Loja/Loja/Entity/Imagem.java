package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String nome;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;
    //RELACIONAMENTO


    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
