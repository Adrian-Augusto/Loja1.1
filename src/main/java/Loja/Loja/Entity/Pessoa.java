package Loja.Loja.Entity;

import Loja.Loja.Repository.CarrinhoCompraRepository;
import Loja.Loja.Repository.PermissaoPessoaRepository;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private  String nome;
    private  String cpf;
    private  String email;
    private String senha;
    private  String endereco;
    private String cep;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;

    // Relacionamento
    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa")
    private List<PermissaoPessoaRepository> permissoes;

    @OneToMany(mappedBy = "pessoa" )
    private List<CarrinhoCompraRepository> carrinhoCompras;

}
