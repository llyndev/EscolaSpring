package com.example.escola.controller;

import com.example.escola.dto.ProfessorDTO;
import com.example.escola.dto.ProfessorRequest;
import com.example.escola.model.Disciplina;
import com.example.escola.model.Professor;
import com.example.escola.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    // Injeção de dependência
    private final ProfessorService professorService;

    // Metodo post para criar professor
    @PostMapping
    public ResponseEntity<ProfessorDTO> create(@RequestBody ProfessorRequest professorRequest) {
        ProfessorDTO professorDTO = professorService.save(professorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorDTO);
    }

    // Metodos GET para retornar a lista de todos os professores
    @GetMapping
    public List<ProfessorDTO> getAll() {
        return professorService.getAll();
    }

    // Metodo GET para retornar professor por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<ProfessorDTO> getByid(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.getByid(id));
    }

    // Metodo GET para retornar professor por matricula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<ProfessorDTO> getByMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(professorService.getByMatricula(matricula));
    }

    // Metodo GET para retornar lista de professores pelo nome
    @GetMapping("/nome")
    public List<ProfessorDTO> getByname(@RequestParam String nome) {
        return professorService.getByName(nome);
    }

    // Metodo GET para retornar lista de professores por data de nascimento
    @GetMapping("/data")
    public List<ProfessorDTO> getByDate(@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy")LocalDate date) {
        return professorService.getByDate(date);
    }

    // Metodo GET para retornar professor por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ProfessorDTO> getByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(professorService.getByCpf(cpf));
    }

    // Metodo GET para retornar professor por RG
    @GetMapping("/rg/{rg}")
    public ResponseEntity<ProfessorDTO> getByRG(@PathVariable String rg) {
        return ResponseEntity.ok(professorService.getByRg(rg));
    }

    // Metodo GET para retornar professores por ID de uma disciplina
    @GetMapping("/disciplina/id")
    public List<ProfessorDTO> getByDisciplinaId(@RequestParam Long disciplinasId){
        return professorService.getByDisciplinasId(disciplinasId);
    }

    // Metodo GET para retornar professores por nome de uma disciplina
    @GetMapping("/disciplina/nome")
    public List<ProfessorDTO> getByDisciplinasNome(@RequestParam String disciplinaNome) {
        return professorService.getByDisciplinaNome(disciplinaNome);
    }

    // Metodo delete por id da entidade professor
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Metodo delete pela matricula do professor
    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<Void> deleteByMatricula(@PathVariable String matricula) {
        professorService.deleteByMatricula(matricula);
        return ResponseEntity.ok().build();
    }

    // Metodo para atualizar professor pela matricula
    @PutMapping("/matricula/{matricula}")
    public ResponseEntity<Void> update(@PathVariable String matricula, @RequestBody Professor professorDetails) {
        professorService.update(matricula, professorDetails);
        return ResponseEntity.ok().build();
    }

}
