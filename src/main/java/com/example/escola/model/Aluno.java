package com.example.escola.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aluno_table")
@Builder
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", length = 15, nullable = false, unique = true)
    private String rg;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Embedded
    @Column(name = "endereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setMatricula(String matricula) {this.matricula = matricula.toUpperCase();}
}
