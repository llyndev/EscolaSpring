package com.example.escola.controller;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.model.Aluno;
import com.example.escola.service.AlunoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    // Injeção de dependencia
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoDTO> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/matricula")
    public ResponseEntity<AlunoDTO> getByid(@RequestParam Long matricula) {
        return ResponseEntity.ok(alunoService.getByid(matricula));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<AlunoDTO>> getByName(@RequestParam String nome) {
        List<AlunoDTO> aluno = alunoService.getByName(nome.toUpperCase());
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/data")
    public ResponseEntity<List<AlunoDTO>> getByDate(@RequestParam("data") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        List<AlunoDTO> aluno = alunoService.getByDate(date);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/cpf")
    public ResponseEntity<AlunoDTO> getByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(alunoService.getByCpf(cpf));
    }

    @GetMapping("/rg")
    public ResponseEntity<AlunoDTO> getByRg(@RequestParam String rg) {
        return ResponseEntity.ok(alunoService.getByRg(rg));
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/matricula")
    public void delete(@RequestParam Long matricula) {
        alunoService.delete(matricula);
    }

    @PutMapping("/matricula")
    public ResponseEntity<Void> update(@RequestParam Long matricula, @RequestBody Aluno alunoDetails) {
        alunoService.update(matricula, alunoDetails);
        return ResponseEntity.ok().build();
    }


}
