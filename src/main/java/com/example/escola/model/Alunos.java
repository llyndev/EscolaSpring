package com.example.escola.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno_table")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long matricula;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 15, nullable = false, unique = true)
    private String rg;

    private String name;

    private String endereco;

    public Alunos() {}

    public Alunos(Long matricula, String cpf, String rg, String name) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getName() {
        return name;
    }

    public String getEndereco() {
        return endereco;
    }
}
