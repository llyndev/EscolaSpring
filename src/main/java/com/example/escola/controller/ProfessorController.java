package com.example.escola.controller;

import com.example.escola.dto.ProfessorDTO;
import com.example.escola.model.Professor;
import com.example.escola.service.ProfessorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
    public List<ProfessorDTO> getAll() {
        return professorService.getAll();
    }

    @GetMapping("/matricula")
    public ResponseEntity<ProfessorDTO> getByid(@RequestParam Long matricula) {
        return ResponseEntity.ok(professorService.getByid(matricula));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ProfessorDTO>> getByname(@RequestParam String nome) {
        List<ProfessorDTO> professor = professorService.getByName(nome.toUpperCase());
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/materia")
    public ResponseEntity<List<ProfessorDTO>> getByLicenciatura(@RequestParam String licenciatura){
        List<ProfessorDTO> professor = professorService.getByLicenciatura(licenciatura.toUpperCase());
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/data")
    public ResponseEntity<List<ProfessorDTO>> getByDate(@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy")LocalDate date) {
        List<ProfessorDTO> professor = professorService.getByDate(date);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/cpf")
    public ResponseEntity<ProfessorDTO> getByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(professorService.getByCpf(cpf));
    }

    @GetMapping("/rg")
    public ResponseEntity<ProfessorDTO> getByRg(@RequestParam String rg) {
        return ResponseEntity.ok(professorService.getByCpf(rg));
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
    public ResponseEntity<Void> update(@RequestParam Long matricula, Professor professorDetails) {
        professorService.update(matricula, professorDetails);
        return ResponseEntity.ok().build();
    }

}
