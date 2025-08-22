package com.example.escola.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;
    private String matricula;
    private String nome;
    private LocalDate dataDeNascimento;
    private String telefone;
    private EnderecoDTO endereco;
    private Set<String> disciplinaNome;
}
