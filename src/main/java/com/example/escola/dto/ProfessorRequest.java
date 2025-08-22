package com.example.escola.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorRequest {

    private String matricula;
    private String cpf;
    private String rg;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private String telefone;
    private EnderecoDTO endereco;

    private Set<Long> disciplinasId;
}
