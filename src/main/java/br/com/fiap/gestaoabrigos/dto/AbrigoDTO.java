package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.*;

public class AbrigoDTO {
    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    @Min(1)
    private Integer capacidade;

    @NotNull
    @Min(0)
    private Integer ocupacao;

    @NotNull
    @Min(0)
    private Integer qtdAgua;

    @NotNull
    @Min(0)
    private Integer qtdRoupa;

    @NotNull
    @Min(0)
    private Integer comidaPorPessoa;

    @NotNull
    @Min(0)
    private Integer qtdDormitorio;

    @NotNull
    private Integer idLocal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Integer ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Integer getQtdAgua() {
        return qtdAgua;
    }

    public void setQtdAgua(Integer qtdAgua) {
        this.qtdAgua = qtdAgua;
    }

    public Integer getQtdRoupa() {
        return qtdRoupa;
    }

    public void setQtdRoupa(Integer qtdRoupa) {
        this.qtdRoupa = qtdRoupa;
    }

    public Integer getComidaPorPessoa() {
        return comidaPorPessoa;
    }

    public void setComidaPorPessoa(Integer comidaPorPessoa) {
        this.comidaPorPessoa = comidaPorPessoa;
    }

    public Integer getQtdDormitorio() {
        return qtdDormitorio;
    }

    public void setQtdDormitorio(Integer qtdDormitorio) {
        this.qtdDormitorio = qtdDormitorio;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }
}