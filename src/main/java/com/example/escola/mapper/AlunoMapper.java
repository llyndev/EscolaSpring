package com.example.escola.mapper;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.dto.AlunoRequest;
import com.example.escola.dto.EnderecoDTO;
import com.example.escola.model.Aluno;
import com.example.escola.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public AlunoDTO toDTO(Aluno aluno) {
        if (aluno == null) return null;

        return  AlunoDTO.builder()
                .id(aluno.getId())
                .matricula(aluno.getMatricula())
                .nome(aluno.getNome())
                .dataDeNascimento(aluno.getDataDeNascimento())
                .telefone(aluno.getTelefone())
                .serieNome(aluno.getSerie() != null ? aluno.getSerie().getNome() : null)
                .serieTurno(aluno.getSerie() != null ? aluno.getSerie().getTurno() : null)
                .serieSala(aluno.getSerie() != null ? aluno.getSerie().getSala() : null)
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

    public Aluno toEntity(AlunoRequest alunoRequest) {
        if (alunoRequest == null) {
            return null;
        }

        Aluno aluno = new Aluno();
        aluno.setMatricula(alunoRequest.getMatricula());
        aluno.setCpf(alunoRequest.getCpf());
        aluno.setRg(alunoRequest.getRg());
        aluno.setNome(alunoRequest.getNome());
        aluno.setDataDeNascimento(alunoRequest.getDataDeNascimento());
        aluno.setTelefone(alunoRequest.getTelefone());

        if (alunoRequest.getEndereco() != null) {
            aluno.setEndereco(new Endereco(
                    alunoRequest.getEndereco().getLogradouro(),
                    alunoRequest.getEndereco().getNumero(),
                    alunoRequest.getEndereco().getComplemento(),
                    alunoRequest.getEndereco().getBairro(),
                    alunoRequest.getEndereco().getCidade(),
                    alunoRequest.getEndereco().getEstado(),
                    alunoRequest.getEndereco().getCep(),
                    alunoRequest.getEndereco().getPais()
            ));
        } return aluno;
    }
}
