package com.example.escola.mapper;

import com.example.escola.dto.EnderecoDTO;
import com.example.escola.dto.ProfessorDTO;
import com.example.escola.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDTO toDTO(Professor professor) {
        if (professor == null) return null;

        return  ProfessorDTO.builder()
                .matricula(professor.getMatricula())
                .nome(professor.getNome())
                .dataDenascimento(professor.getDataDeNascimento())
                .licenciatura(professor.getLicenciatura())
                .telefone(professor.getTelefone())
                .endereco(
                        professor.getEndereco() != null ? new EnderecoDTO(
                                professor.getEndereco().getLogradouro(),
                                professor.getEndereco().getNumero(),
                                professor.getEndereco().getComplemento(),
                                professor.getEndereco().getBairro(),
                                professor.getEndereco().getCidade(),
                                professor.getEndereco().getEstado(),
                                professor.getEndereco().getCep(),
                                professor.getEndereco().getPais()
                        ) : null
                )
                .build();
    }
}
