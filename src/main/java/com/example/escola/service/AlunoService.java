package com.example.escola.service;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.mapper.AlunoMapper;
import com.example.escola.model.Aluno;
import com.example.escola.repository.AlunoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    // Listar
    public List<AlunoDTO> getAll() {
        List<Aluno> aluno = alunoRepository.findAll();

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Listar por id
    public AlunoDTO getByid(Long matricula) {

        return alunoRepository.findById(matricula)
                .map(alunoMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Aluno não encontrado.")
        );
    }

    // Listar por nome
    public List<AlunoDTO> getByName(String name) {
        List<Aluno> aluno = alunoRepository.findByNomeContainsIgnoreCase(name);

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Listar por data
    public List<AlunoDTO> getByDate(@JsonFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        List<Aluno> aluno = alunoRepository.findByDate(date);

        return aluno.stream()
                .map(alunoMapper::toDTO)
                .toList();
    }

    // Listar por cpf
    public AlunoDTO getByCpf(String cpf) {

        Aluno aluno = alunoRepository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não encontrado")
        );
        return alunoMapper.toDTO(aluno);
    }

    // Listar por rg
    public AlunoDTO getByRg(String rg) {
        Aluno aluno = alunoRepository.findByRg(rg).orElseThrow(
                () -> new RuntimeException("RG não encontrado")
        );
        return alunoMapper.toDTO(aluno);

    }

    // Criar
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Deletar
    public void delete(Long matricula) {
        alunoRepository.deleteById(matricula);
    }

    // Atualizar
    public void update(Long matricula, Aluno aluno) {
        Aluno alunoEntity = alunoRepository.findById(matricula).orElseThrow(() ->
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
                .build();
        alunoRepository.saveAndFlush(alunoAtualiado);
    }
}
