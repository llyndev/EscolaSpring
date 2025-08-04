package com.example.escola.service;

import com.example.escola.model.Professor;
import com.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    // Listar por licenciatura
    public List<Professor> getByLicenciatura(String licenciatura) {
        return professorRepository.findByLicenciatura(licenciatura);
    }

    // Listar por data de nascimento
    public List<Professor> getByDate(LocalDate date) {
        return professorRepository.finByDate(date);
    }

    // Listar por cpf
    public List<Professor> getByCpf(String cpf) {
        return professorRepository.findByCpf(cpf);
    }

    // Listar por rg
    public List<Professor> getByRg(String rg) {
        return professorRepository.findByRg(rg);
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
