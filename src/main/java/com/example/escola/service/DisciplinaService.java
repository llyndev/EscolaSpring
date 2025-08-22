package com.example.escola.service;

import com.example.escola.model.Disciplina;

import com.example.escola.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    // Metodo para criar uma nova disciplina
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    // Retorna todas as disciplinas criadas
    public List<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }

    // Retorna disciplina pelo ID
    public Disciplina getById(Long id) {
        return disciplinaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Disciplina não encontrada!"));
    }
}
