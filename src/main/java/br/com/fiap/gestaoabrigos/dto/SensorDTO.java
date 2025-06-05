package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.*;
import java.util.Date;

public class SensorDTO {
    @NotNull
    private Integer id;

    @NotBlank
    private String valorLido;

    @NotNull
    private Date dataHora;

    @NotNull
    private Integer idAbrigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValorLido() {
        return valorLido;
    }

    public void setValorLido(String valorLido) {
        this.valorLido = valorLido;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getIdAbrigo() {
        return idAbrigo;
    }

    public void setIdAbrigo(Integer idAbrigo) {
        this.idAbrigo = idAbrigo;
    }
}