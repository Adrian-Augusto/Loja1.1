package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricaoCurta;
    String descricaoDetalhada;
     private Double valor;
     private  Double valorVenda;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;

        //RELACIONAMENTO
    @OneToMany(mappedBy = "produto")
    private List<CarrinhoCompraProduto> carrinhos;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name = "Marca_id")
    private Marca Marca;


    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagem> imagens;

}
