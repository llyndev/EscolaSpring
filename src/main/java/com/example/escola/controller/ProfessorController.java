package com.example.escola.controller;

import com.example.escola.model.Professor;
import com.example.escola.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAll() {
        return professorService.getAll();
    }

    @GetMapping("/{matricula}")
    public Optional<Professor> getByid(@PathVariable Long matricula) {
        return professorService.getByid(matricula);
    }

    @GetMapping("/nome/{name}")
    public List<Professor> getByname(@PathVariable String name) {
        return professorService.getByName(name.toUpperCase());
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return professorService.create(professor);
    }

    @DeleteMapping("/{matricula}")
    public void delete(@PathVariable Long matricula) {
        professorService.delete(matricula);
    }

    @PutMapping("/{matricula}")
    public Professor update(@PathVariable Long matricula, Professor professorDetails) {
        Professor professor = professorService.getByid(matricula)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setCpf(professorDetails.getCpf());
        professor.setRg(professorDetails.getRg());
        professor.setName(professorDetails.getName());
        professor.setLicenciatura(professorDetails.getLicenciatura());
        professor.setEndereco(professorDetails.getEndereco());

        return professorService.save(professor);
    }

}
