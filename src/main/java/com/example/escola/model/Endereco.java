package com.example.escola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

    @Column(name = "end_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "end_numero", nullable = false)
    private String numero;

    @Column(name = "end_complemento")
    private String complemento;

    @Column(name = "end_bairro", nullable = false)
    private String bairro;

    @Column(name = "end_cidade", nullable = false)
    private String cidade;

    @Column(name = "end_estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "end_cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "end_pais", nullable = false)
    private String pais;
}
