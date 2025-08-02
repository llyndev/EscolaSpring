package com.example.escola.service;

import com.example.escola.model.Aluno;
import com.example.escola.repository.AlunoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Listar
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    // Listar por id
    public Optional<Aluno> getByid(Long matricula) {
        return alunoRepository.findById(matricula);
    }

    // Listar por nome
    public List<Aluno> getByName(String name) {
        return alunoRepository.findByName(name);
    }

    // Listar por data
    public List<Aluno> getByDate(@JsonFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return alunoRepository.findByDate(date);
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
    public Aluno update(Long matricula, Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
