package com.example.escola.service;

import com.example.escola.model.Alunos;
import com.example.escola.repository.AlunosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    private final AlunosRepository alunosRepository;

    public AlunosService(AlunosRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    // Listar
    public List<Alunos> getAll() {
        return alunosRepository.findAll();
    }

    // Criar
    public Alunos save(Alunos alunos) {
        return alunosRepository.save(alunos);
    }

    // Deletar
    public void delete(Long matricula) {
        alunosRepository.deleteById(matricula);
    }
}
