package com.example.escola.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoDTO {

    private Long id;
    private String matricula;
    private String nome;
    private LocalDate dataDeNascimento;
    private String telefone;
    private EnderecoDTO endereco;
    private String serieNome;
    private String serieSala;
    private String serieTurno;
}
