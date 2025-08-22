package com.example.escola.service;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.dto.AlunoRequest;
import com.example.escola.mapper.AlunoMapper;
import com.example.escola.model.Aluno;
import com.example.escola.model.Serie;
import com.example.escola.repository.AlunoRepository;
import com.example.escola.repository.SerieRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;
    private final SerieRepository serieRepository;

    // Retorna todos os alunos
    public List<AlunoDTO> getAll() {
        List<Aluno> aluno = alunoRepository.findAll();

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Retorna o aluno pelo ID ou lança RuntimeException se não encontrado
    public AlunoDTO getByid(Long id) {

        return alunoRepository.findById(id)
                .map(alunoMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Aluno não encontrado.")
        );
    }

    // Retorna aluno que esta em uma serie pelo nome dela
    public List<AlunoDTO> getBySerieNome(String serieNome) {
        List<Aluno> aluno = alunoRepository.findBySerieNomeContainsIgnoreCase(serieNome);
        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Retorna aluno que esta em uma serie pelo ID dela
    public List<AlunoDTO> getBySerieId(Long serieId) {
        List<Aluno> aluno = alunoRepository.findBySerieId(serieId);
        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Retorna um aluno pela matricula ou lança RuntimeException se não encontrado
    public AlunoDTO getByMatricula(String matricula) {

        return alunoRepository.findByMatriculaContainingIgnoreCase(matricula)
                .map(alunoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    // Retorna aluno pelo nome
    public List<AlunoDTO> getByName(String name) {
        List<Aluno> aluno = alunoRepository.findByNomeContainsIgnoreCase(name);

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Retorna aluno pela data de nascimento
    public List<AlunoDTO> getByDate(@JsonFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        List<Aluno> aluno = alunoRepository.findByDate(date);

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Retorna aluno pelo CPF
    public AlunoDTO getByCpf(String cpf) {

        Aluno aluno = alunoRepository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não encontrado")
        );
        return alunoMapper.toDTO(aluno);
    }

    // Retorna aluno pelo RG
    public AlunoDTO getByRg(String rg) {
        Aluno aluno = alunoRepository.findByRg(rg).orElseThrow(
                () -> new RuntimeException("RG não encontrado")
        );
        return alunoMapper.toDTO(aluno);

    }

    // Criar aluno
    public AlunoDTO save(AlunoRequest alunoRequest) {
        Serie serie = serieRepository.findById(alunoRequest.getSerieId()).orElseThrow( () -> new RuntimeException("Serie não encontrada"));

        Aluno aluno = alunoMapper.toEntity(alunoRequest);
        aluno.setSerie(serie);

        aluno = alunoRepository.save(aluno);

        return alunoMapper.toDTO(aluno);
    }

    // Deletar aluno pelo ID
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    // Deletar aluno pela matricula
    public void deleteByMatricula(String matricula) {
        alunoRepository.deleteByMatricula(matricula);
    }

    // Atualizar aluno pela matricula
    public void update(String matricula, Aluno aluno) {
        Aluno alunoEntity = alunoRepository.findByMatriculaContainingIgnoreCase(matricula).orElseThrow(() ->
                new RuntimeException("Aluno não encontrado"));

        Aluno alunoAtualiado = Aluno.builder()

                .cpf(aluno.getCpf() != null ? aluno.getCpf() :
                        alunoEntity.getCpf())
                .rg(aluno.getRg() != null ? aluno.getRg() :
                        alunoEntity.getRg())
                .nome(aluno.getNome() != null ? aluno.getNome() :
                        alunoEntity.getNome())
                .dataDeNascimento(aluno.getDataDeNascimento() != null ? aluno.getDataDeNascimento() :
                        alunoEntity.getDataDeNascimento())
                .telefone(aluno.getTelefone() != null ? aluno.getTelefone() :
                        alunoEntity.getTelefone())
                .endereco(aluno.getEndereco() != null ? aluno.getEndereco() :
                        alunoEntity.getEndereco())
                .matricula(alunoEntity.getMatricula())
                .id(alunoEntity.getId())
                .build();
        alunoRepository.saveAndFlush(alunoAtualiado);
    }
}
