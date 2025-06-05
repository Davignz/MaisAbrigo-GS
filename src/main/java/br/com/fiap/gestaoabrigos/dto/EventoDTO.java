package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.*;
import java.util.Date;

public class EventoDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotNull
    private Date dataHora;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer nivel;

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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}