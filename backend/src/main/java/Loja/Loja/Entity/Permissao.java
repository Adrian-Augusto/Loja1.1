package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @Temporal(TemporalType.TIMESTAMP)
    Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    Date dataAtualizacao;

    // Adicionando os campos ausentes
    String email;
    String endereco;
    String cep;
    String cidade;

    // Relacionamento com a entidade PermissaoPessoaRepository
    @OneToMany(mappedBy = "permissao")
    private List<Permissao> pessoas;
}
