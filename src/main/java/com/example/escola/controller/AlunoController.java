package com.example.escola.controller;

import com.example.escola.model.Aluno;
import com.example.escola.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    // Injeção de dependencia
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/{matricula}")
    public Optional<Aluno> getByid(@PathVariable Long matricula) {
        return alunoService.getByid(matricula);
    }

    @GetMapping("/nome/{name}")
    public List<Aluno> getByName(@PathVariable String name) {
        return alunoService.getByName(name.toUpperCase());
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{matricula}")
    public void delete(@PathVariable Long matricula) {
        alunoService.delete(matricula);
    }

    @PutMapping("/{matricula}")
    public Aluno update(@PathVariable Long matricula, @RequestBody Aluno alunoDetails) {
        Aluno aluno = alunoService.getByid(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setCpf(alunoDetails.getCpf());
        aluno.setRg(alunoDetails.getRg());
        aluno.setName(alunoDetails.getName());
        aluno.setEndereco(alunoDetails.getEndereco());

        return alunoService.save(aluno);

    }


}
