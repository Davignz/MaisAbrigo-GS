package br.com.fiap.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "tbl_sensor")
public class Sensor {
    @Id
    @Column(name = "id_sensor")
    private Integer id;

    @NotBlank
    @Column(name = "valor_lido")
    private String valorLido;

    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "id_abrigo")
    private Abrigo abrigo;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getValorLido() { return valorLido; }
    public void setValorLido(String valorLido) { this.valorLido = valorLido; }

    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public Abrigo getAbrigo() { return abrigo; }
    public void setAbrigo(Abrigo abrigo) { this.abrigo = abrigo; }
}