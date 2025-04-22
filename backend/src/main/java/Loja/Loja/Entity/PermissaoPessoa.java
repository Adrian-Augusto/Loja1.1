package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.patterns.PerObject;

import  java.util.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PermissaoPessoa")
public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataAtualizacao;
    // Relacionamento

    @ManyToOne
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

    @ManyToOne
    @JoinColumn(name = "Pessoa_id")
    private Pessoa pessoa;
}