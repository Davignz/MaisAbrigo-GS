package br.com.fiap.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tbl_voluntarios")
public class Voluntario {
    @Id
    @Column(name = "id_voluntario")
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
    @Column(name = "numero_cel")
    private String numeroCel;

    @ManyToOne
    @JoinColumn(name = "id_abrigo")
    private Abrigo abrigo;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getDdd() { return ddd; }
    public void setDdd(Integer ddd) { this.ddd = ddd; }

    public String getNumeroCel() { return numeroCel; }
    public void setNumeroCel(String numeroCel) { this.numeroCel = numeroCel; }

    public Abrigo getAbrigo() { return abrigo; }
    public void setAbrigo(Abrigo abrigo) { this.abrigo = abrigo; }
}