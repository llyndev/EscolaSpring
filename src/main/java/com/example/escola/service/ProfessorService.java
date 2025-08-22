package com.example.escola.service;

import com.example.escola.dto.ProfessorDTO;
import com.example.escola.dto.ProfessorRequest;
import com.example.escola.mapper.ProfessorMapper;
import com.example.escola.model.Disciplina;
import com.example.escola.model.Professor;
import com.example.escola.repository.DisciplinaRepository;
import com.example.escola.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final DisciplinaRepository disciplinaRepository;

    // Retorna todos os professores
    public List<ProfessorDTO> getAll() {
        List<Professor> professor = professorRepository.findAll();

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Retorna professor por ID ou lança RuntimeException se não encontrado
    public ProfessorDTO getByid(Long id) {
        return professorRepository.findById(id)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
                );

    }

    // Retorna professor por matricula ou lança RuntimeException se não encontrado
    public ProfessorDTO getByMatricula(String matricula) {
        return professorRepository.findByMatriculaContainingIgnoreCase(matricula)
                .map(professorMapper::toDTO)
                .orElseThrow(
                        () -> new RuntimeException("Professor não encontrado")
                );
    }

    // Retorna professor por nome
    public List<ProfessorDTO> getByName(String name) {
        List<Professor> professor = professorRepository.findByNomeContainingIgnoreCase(name);
        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Retorna professor por data de nascimento
    public List<ProfessorDTO> getByDate(LocalDate date) {
        List<Professor> professor = professorRepository.finByDate(date);

        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Retorna professor por CPF
    public ProfessorDTO getByCpf(String cpf) {
        return professorRepository.findByCpf(cpf)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
        );
    }

    // Retorna professor por RG
    public ProfessorDTO getByRg(String rg) {

        return professorRepository.findByRg(rg)
                .map(professorMapper::toDTO)
                .orElseThrow(
                () -> new RuntimeException("Professor não encontrado")
        );
    }

    // Reporta professor pelo id da sua disciplina
    public List<ProfessorDTO> getByDisciplinasId(Long disciplinasId) {
        List<Professor> professor = professorRepository.findByDisciplinasId(disciplinasId);
        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Listar professor pelo nome da sua disciplina
    public List<ProfessorDTO> getByDisciplinaNome(String disciplinasNome) {
        List<Professor> professor = professorRepository.findByDisciplinasNomeContainingIgnoreCase(disciplinasNome);
        return professor.stream()
                .map(professorMapper::toDTO)
                .toList();
    }

    // Criar professor
    public ProfessorDTO save(ProfessorRequest professorRequest) {
        Set<Disciplina> disciplinas = new HashSet<>(disciplinaRepository.findAllById(professorRequest.getDisciplinasId()));

        if (disciplinas.isEmpty()){
            throw new RuntimeException("Nenhuma disciplina encontrada para o ID informado");
        }

        Professor professor = professorMapper.toEntity(professorRequest);

        professor.setDisciplinas(disciplinas);

        professor = professorRepository.save(professor);

        return professorMapper.toDTO(professor);
    }

    // Deleter professor por ID
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }

    // Deletar professor por matricula
    public void deleteByMatricula(String matricula) {
        professorRepository.deleteByMatriculaContainingIgnoreCase(matricula);
    }

    // Atualizar professor por matricula
    public void update(String matricula, Professor professor) {
        Professor professorEntity = professorRepository.findByMatriculaContainingIgnoreCase(matricula).orElseThrow(() ->
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

                .id(professorEntity.getId())

                .build();
        professorRepository.saveAndFlush(professorAtualiado);
    }

}
