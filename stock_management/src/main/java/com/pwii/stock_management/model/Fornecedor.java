package com.pwii.stock_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank
    @Size(max = 150)
    private String nome;

    @Column(name = "cnpj", nullable = false)
    @NotBlank
    @Size(max = 25)
    private String cnpj;

    @Column(name = "endereco", nullable = false)
    @NotBlank
    @Size(max = 150)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    @NotBlank
    @Size(max = 20)
    private String telefone;
}
