package com.example.escola.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "professores_table")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 15, nullable = false, unique = true)
    private String rg;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private String licenciatura;

    private String endereco;

    public Professor() {}

    public Professor(Long matricula, String cpf, String rg, String nome, LocalDate dataDeNascimento, String licenciatura, String endereco) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.licenciatura = licenciatura;
        this.endereco = endereco;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura.toUpperCase();
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

    public String getNome() {
        return nome;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public String getEndereco() {
        return endereco;
    }
}
