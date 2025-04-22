package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "CarrinhoCompraProduto")
public class CarrinhoCompraProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;
    //Relacionamento
    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoCompra carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
