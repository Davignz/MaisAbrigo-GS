package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.*;
import java.util.Date;

public class ResgatadoDTO {
    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Size(max = 10)
    private String estadoSaude;

    @NotNull
    private Date dataHoraResgate;

    @NotNull
    @Min(10)
    @Max(99)
    private Integer ddd;

    @NotBlank
    @Size(max = 10)
    private String numeroCel;

    @NotNull
    private Integer idAbrigo;

    @NotNull
    private Integer idEvento;

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

    public String getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(String estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public Date getDataHoraResgate() {
        return dataHoraResgate;
    }

    public void setDataHoraResgate(Date dataHoraResgate) {
        this.dataHoraResgate = dataHoraResgate;
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

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
}