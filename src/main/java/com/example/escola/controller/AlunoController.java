package com.example.escola.controller;

import com.example.escola.dto.AlunoDTO;
import com.example.escola.dto.AlunoRequest;
import com.example.escola.model.Aluno;
import com.example.escola.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    // Injeção de dependência
    private final AlunoService alunoService;

    // Metodos GET
    @GetMapping
    public List<AlunoDTO> getAll() {
        return alunoService.getAll();
    }

    // Metodo GET para receber lista de todos os alunos
    @GetMapping("/id/{id}")
    public ResponseEntity<AlunoDTO> getByid(@PathVariable  Long id) {
        return ResponseEntity.ok(alunoService.getByid(id));
    }

    // Metodo GET para receber alunos de uma determinada serie por nome da serie
    @GetMapping("/serie/nome")
    public List<AlunoDTO> getBySerieNome(@RequestParam String serieNome) {
        return alunoService.getBySerieNome(serieNome);
    }

    // Metodo GET para receber alunos de uma determinada serie por ID da serie
    @GetMapping("/serie/id")
    public List<AlunoDTO> getBySerieId(@RequestParam Long serieId) {
        return alunoService.getBySerieId(serieId);
    }

    // Metodo GET para receber aluno pela matricula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<AlunoDTO> getByMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(alunoService.getByMatricula(matricula));
    }

    // Metodo GET para receber lista de alunos pelo nome
    @GetMapping("/nome")
    public List<AlunoDTO> getByName(@RequestParam String nome) {
        return alunoService.getByName(nome);
    }

    // Metodo GET para receber lista de alunos pela data de nascimento
    @GetMapping("/data")
    public List<AlunoDTO> getByDate(@RequestParam("data") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return alunoService.getByDate(date);
    }

    // Metodo GET para receber aluno por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoDTO> getByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(alunoService.getByCpf(cpf));
    }

    // Metodo GET para receber aluno por RG
    @GetMapping("/rg/{rg}")
    public ResponseEntity<AlunoDTO> getByRg(@PathVariable String rg) {
        return ResponseEntity.ok(alunoService.getByRg(rg));
    }

    // Metodo Post para criar um aluno
    @PostMapping
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoRequest alunoRequest) {
        AlunoDTO alunoDTO = alunoService.save(alunoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    // Metodo Delete para deletar um aluno pelo ID
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Metodo Delete para deltar um aluno pela matricula
    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<Void> deleteByMatricula(@PathVariable String matricula) {
        alunoService.deleteByMatricula(matricula);
        return ResponseEntity.noContent().build();
    }

    // Metodo Put para atualizar um aluno pela matricula
    @PutMapping("/matricula/{matricula}")
    public ResponseEntity<Void> update(@PathVariable String matricula, @RequestBody Aluno alunoDetails) {
        alunoService.update(matricula, alunoDetails);
        return ResponseEntity.ok().build();
    }


}
