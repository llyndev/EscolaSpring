package com.example.escola.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professores_table")
@Builder
@Entity
public class Professor {

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

    @ManyToMany
    @JoinTable(
            name = "professor_disciplina",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas = new HashSet<>();

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setMatricula(String matricula) {this.matricula = matricula.toUpperCase();}
}
