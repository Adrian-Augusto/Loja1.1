package Loja.Loja.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String nome;
    String sigla;
    LocalDateTime  DataCriacao;
    LocalDateTime  DataAtualizacao;

}
