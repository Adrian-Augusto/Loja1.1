package Loja.Loja.Entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String sigla;
    @Temporal(TemporalType.TIMESTAMP)
    Date  DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    Date DataAtualizacao;
    @OneToMany(mappedBy = "Estado", cascade = CascadeType.ALL)
    private  List<Cidade> cidades;

}
