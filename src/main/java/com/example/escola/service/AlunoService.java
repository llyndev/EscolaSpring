package com.example.escola.service;

import com.example.escola.model.Aluno;
import com.example.escola.repository.AlunoRepository;
import org.springframework.stereotype.Service;

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
