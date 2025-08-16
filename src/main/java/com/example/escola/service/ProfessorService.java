package com.example.escola.service;

import com.example.escola.dto.ProfessorDTO;
import com.example.escola.mapper.ProfessorMapper;
import com.example.escola.model.Aluno;
import com.example.escola.model.Professor;
import com.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper){
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    // Listar todos
    public List<ProfessorDTO> getAll() {
        List<Professor> professor = professorRepository.findAll();

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Listar por id
    public ProfessorDTO getByid(Long matricula) {
        return professorRepository.findById(matricula)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
                );

    }

    // Listar por nome
    public List<ProfessorDTO> getByName(String name) {
        List<Professor> professor = professorRepository.findByNomeContainingIgnoreCase(name);

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Listar por licenciatura
    public List<ProfessorDTO> getByLicenciatura(String licenciatura) {
        List<Professor> professor = professorRepository.findByLicenciaturaContainingIgnoreCase(licenciatura);

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Listar por data de nascimento
    public List<ProfessorDTO> getByDate(LocalDate date) {
        List<Professor> professor = professorRepository.finByDate(date);

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Listar por cpf
    public ProfessorDTO getByCpf(String cpf) {
        return professorRepository.findByCpf(cpf)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
        );
    }

    // Listar por rg
    public ProfessorDTO getByRg(String rg) {

        return professorRepository.findByRg(rg)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
        );
    }

    // Criar
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    // Deletar por id
    public void delete(Long matricula) {
        professorRepository.deleteById(matricula);
    }

    // Salvar
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    // Atualizar
    public void update(Long matricula, Professor professor) {
        Professor professorEntity = professorRepository.findById(matricula).orElseThrow(() ->
                new RuntimeException("Aluno não encontrado"));
        Professor professorAtualiado = Professor.builder()
                .cpf(professor.getCpf() != null ? professor.getCpf() :
                        professorEntity.getCpf())
                .rg(professor.getRg() != null ? professor.getRg() :
                        professorEntity.getRg())
                .nome(professor.getNome() != null ? professor.getNome() :
                        professorEntity.getNome())
                .dataDeNascimento(professor.getDataDeNascimento() != null ? professor.getDataDeNascimento() :
                        professorEntity.getDataDeNascimento())
                .telefone(professor.getTelefone() != null ? professor.getTelefone() :
                        professorEntity.getTelefone())
                .endereco(professor.getEndereco() != null ? professor.getEndereco() :
                        professorEntity.getEndereco())
                .matricula(professorEntity.getMatricula())
                .build();
        professorRepository.saveAndFlush(professorAtualiado);
    }

}
