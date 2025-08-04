package com.example.escola.controller;

import com.example.escola.model.Professor;
import com.example.escola.service.ProfessorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/matricula")
    public Optional<Professor> getByid(@RequestParam Long matricula) {
        return professorService.getByid(matricula);
    }

    @GetMapping("/nome")
    public List<Professor> getByname(@RequestParam String nome) {
        return professorService.getByName(nome.toUpperCase());
    }

    @GetMapping("/materia")
    public List<Professor> getByLicenciatura(@RequestParam String licenciatura){
        return professorService.getByLicenciatura(licenciatura.toUpperCase());
    }

    @GetMapping("/data")
    public List<Professor> getByDate(@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy")LocalDate date) {
        return professorService.getByDate(date);
    }

    @GetMapping("/cpf")
    public List<Professor> getByCpf(@RequestParam String cpf) {
        return professorService.getByCpf(cpf);
    }

    @GetMapping("/rg")
    public List<Professor> getByRg(@RequestParam String rg) {
        return professorService.getByCpf(rg);
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return professorService.create(professor);
    }

    @DeleteMapping("/matricula")
    public void delete(@RequestParam Long matricula) {
        professorService.delete(matricula);
    }

    @PutMapping("/matricula")
    public Professor update(@RequestParam Long matricula, Professor professorDetails) {
        Professor professor = professorService.getByid(matricula)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setCpf(professorDetails.getCpf());
        professor.setRg(professorDetails.getRg());
        professor.setNome(professorDetails.getNome());
        professor.setLicenciatura(professorDetails.getLicenciatura());
        professor.setEndereco(professorDetails.getEndereco());

        return professorService.save(professor);
    }

}
