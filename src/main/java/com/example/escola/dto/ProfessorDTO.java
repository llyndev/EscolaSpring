package com.example.escola.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long matricula;
    private String nome;
    private LocalDate dataDenascimento;
    private String licenciatura;
    private String telefone;
    private EnderecoDTO endereco;
}
