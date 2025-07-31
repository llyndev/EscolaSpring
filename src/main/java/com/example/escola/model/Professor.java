package com.example.escola.model;

import jakarta.persistence.*;

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

    private String name;

    private String licenciatura;

    private String endereco;

    public Professor() {}

    public Professor(Long matricula, String cpf, String rg, String name, String licenciatura, String endereco) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.licenciatura = licenciatura;
        this.endereco = endereco;
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
        this.name = name.toUpperCase();
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
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

    public String getLicenciatura() {
        return licenciatura;
    }

    public String getEndereco() {
        return endereco;
    }
}
