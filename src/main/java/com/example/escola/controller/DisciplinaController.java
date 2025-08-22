package com.example.escola.controller;

import com.example.escola.model.Disciplina;
import com.example.escola.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    // injeção de dependência
    private final DisciplinaService disciplinaService;

    // Metodo POST para criar uma disciplina
    @PostMapping
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
        Disciplina nova = disciplinaService.save(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    // Metodo GET para retornar todas as disciplinas
    @GetMapping
    public List<Disciplina> getAll() {
        return disciplinaService.getAll();
    }

    // Metodo GET para retornar disciplina por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Disciplina> getById(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.getById(id));
    }

}
