package com.example.escola.service;

import com.example.escola.model.Serie;
import com.example.escola.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final SerieRepository serieRepository;

    // Criar uma nova serie
    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    // Retorna todas as series criada
    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    // Retorna serie por ID
    public Serie getById(Long id) {
        return serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Serie não encontrada"));
    }

}
