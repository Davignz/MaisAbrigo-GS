package br.com.fiap.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tbl_abrigo")
public class Abrigo {
    @Id
    @Column(name = "id_abrigo")
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
    @Column(name = "qtd_agua")
    private Integer qtdAgua;

    @NotNull
    @Min(0)
    @Column(name = "qtd_roupa")
    private Integer qtdRoupa;

    @NotNull
    @Min(0)
    @Column(name = "comida_por_pessoa")
    private Integer comidaPorPessoa;

    @NotNull
    @Min(0)
    @Column(name = "qtd_dormitorio")
    private Integer qtdDormitorio;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private Localizacao localizacao;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public Integer getOcupacao() { return ocupacao; }
    public void setOcupacao(Integer ocupacao) { this.ocupacao = ocupacao; }

    public Integer getQtdAgua() { return qtdAgua; }
    public void setQtdAgua(Integer qtdAgua) { this.qtdAgua = qtdAgua; }

    public Integer getQtdRoupa() { return qtdRoupa; }
    public void setQtdRoupa(Integer qtdRoupa) { this.qtdRoupa = qtdRoupa; }

    public Integer getComidaPorPessoa() { return comidaPorPessoa; }
    public void setComidaPorPessoa(Integer comidaPorPessoa) { this.comidaPorPessoa = comidaPorPessoa; }

    public Integer getQtdDormitorio() { return qtdDormitorio; }
    public void setQtdDormitorio(Integer qtdDormitorio) { this.qtdDormitorio = qtdDormitorio; }

    public Localizacao getLocalizacao() { return localizacao; }
    public void setLocalizacao(Localizacao localizacao) { this.localizacao = localizacao; }
}