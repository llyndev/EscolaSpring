package com.example.escola.controller;

import com.example.escola.model.Serie;
import com.example.escola.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
@RequiredArgsConstructor
public class SerieController {

    // Injeção de dependência
    private final SerieService serieService;

    // Metodo POST para criar uma sala de aula
    @PostMapping
    public Serie create(@RequestBody Serie serie) {
        return serieService.save(serie);
    }

    // Metodo GET para retornar todas as serie
    @GetMapping
    public List<Serie> getAll() {
        return serieService.getAll();
    }

    // Metodo GET para retornar serie por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Serie> getById(@PathVariable Long id) {
        return  ResponseEntity.ok(serieService.getById(id));
    }

}
