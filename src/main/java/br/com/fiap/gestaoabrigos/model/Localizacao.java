package br.com.fiap.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tbl_localizacao")
public class Localizacao {
    @Id
    @Column(name = "id_local")
    private Integer id;

    @NotBlank
    @Size(max = 30)
    private String rua;

    @NotNull
    private Integer numero;

    @NotBlank
    @Size(max = 9)
    private String cep;

    @NotNull
    private Double latitude;

    @NotNull
    private Double altitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
}