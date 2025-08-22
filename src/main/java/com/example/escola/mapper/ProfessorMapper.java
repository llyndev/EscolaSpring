package com.example.escola.mapper;

import com.example.escola.dto.EnderecoDTO;
import com.example.escola.dto.ProfessorDTO;
import com.example.escola.dto.ProfessorRequest;
import com.example.escola.model.Disciplina;
import com.example.escola.model.Endereco;
import com.example.escola.model.Professor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessorMapper {

    public ProfessorDTO toDTO(Professor professor) {
        if (professor == null) return null;

        return  ProfessorDTO.builder()
                .id(professor.getId())
                .matricula(professor.getMatricula())
                .nome(professor.getNome())
                .dataDeNascimento(professor.getDataDeNascimento())
                .telefone(professor.getTelefone())
                .disciplinaNome(
                        professor.getDisciplinas() != null ?
                                professor.getDisciplinas()
                                        .stream()
                                        .map(Disciplina::getNome)
                                        .collect(Collectors.toSet())
                                : null
                )
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

    public Professor toEntity(ProfessorRequest professorRequest) {
        if (professorRequest == null) {
            return null;
        }

        Professor professor = new Professor();
        professor.setMatricula(professorRequest.getMatricula());
        professor.setCpf(professorRequest.getCpf());
        professor.setRg(professorRequest.getRg());
        professor.setNome(professorRequest.getNome());
        professor.setDataDeNascimento(professorRequest.getDataDeNascimento());
        professor.setTelefone(professorRequest.getTelefone());

        if (professorRequest.getEndereco() != null) {
            professor.setEndereco(new Endereco(
                    professorRequest.getEndereco().getLogradouro(),
                    professorRequest.getEndereco().getNumero(),
                    professorRequest.getEndereco().getComplemento(),
                    professorRequest.getEndereco().getBairro(),
                    professorRequest.getEndereco().getCidade(),
                    professorRequest.getEndereco().getEstado(),
                    professorRequest.getEndereco().getCep(),
                    professorRequest.getEndereco().getPais()
            ));
        } return professor;
    }
}
