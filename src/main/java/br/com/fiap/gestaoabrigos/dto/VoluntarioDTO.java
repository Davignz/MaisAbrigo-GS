package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.*;

public class VoluntarioDTO {
    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    @Min(10)
    @Max(99)
    private Integer ddd;

    @NotBlank
    @Size(max = 10)
    private String numeroCel;

    @NotNull
    private Integer idAbrigo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    public Integer getIdAbrigo() {
        return idAbrigo;
    }

    public void setIdAbrigo(Integer idAbrigo) {
        this.idAbrigo = idAbrigo;
    }
}