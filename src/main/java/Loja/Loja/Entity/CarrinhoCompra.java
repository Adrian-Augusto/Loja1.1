package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "CarinhoCompra")
@Data
public class CarrinhoCompra {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Data dataCompra;
    String observacao;
    String situacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;

    //RELACIONAMENTO


    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    // Um carrinho pode ter vários produtos (com quantidade, valor etc)
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<CarrinhoCompraProduto> produtos;


}
