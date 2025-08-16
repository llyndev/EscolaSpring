package com.example.escola.mapper;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.dto.EnderecoDTO;
import com.example.escola.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public AlunoDTO toDTO(Aluno aluno) {
        if (aluno == null) return null;

        return  AlunoDTO.builder()
                .matricula(aluno.getMatricula())
                .nome(aluno.getNome())
                .dataDenascimento(aluno.getDataDeNascimento())
                .telefone(aluno.getTelefone())
                .endereco(
                        aluno.getEndereco() != null ? new EnderecoDTO(
                                aluno.getEndereco().getLogradouro(),
                                aluno.getEndereco().getNumero(),
                                aluno.getEndereco().getComplemento(),
                                aluno.getEndereco().getBairro(),
                                aluno.getEndereco().getCidade(),
                                aluno.getEndereco().getEstado(),
                                aluno.getEndereco().getCep(),
                                aluno.getEndereco().getPais()
                        ) : null
                )
                .build();
    }
}
