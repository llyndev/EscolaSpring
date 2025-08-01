package com.example.escola.service;

import com.example.escola.model.Professor;
import com.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    // Listar todos
    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    // Listar por id
    public Optional<Professor> getByid(Long matricula) {
        return professorRepository.findById(matricula);
    }

    // Listar por nome
    public List<Professor> getByName(String name) {
        return professorRepository.findByName(name);
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


}
