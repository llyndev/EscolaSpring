package com.example.escola.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "serie")
@Builder
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_serie", nullable = false,unique = true)
    private String nome;

    @Column(name = "sala", nullable = false)
    private String sala;

    @Column(name = "turno", nullable = false)
    private String turno;

    @OneToMany(mappedBy = "serie")
    private Set<Aluno> alunos = new HashSet<>();
}
