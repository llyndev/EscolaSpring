package com.example.escola.controller;

import com.example.escola.model.Alunos;
import com.example.escola.service.AlunosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    // Injeção de dependencia
    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping
    public List<Alunos> getAll() {
        return alunosService.getAll();
    }

    @PostMapping
    public Alunos create(@RequestBody Alunos alunos) {
        return alunosService.save(alunos);
    }


}
