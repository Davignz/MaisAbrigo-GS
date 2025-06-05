package br.com.fiap.gestaoabrigos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "tbl_resgatados")
public class Resgatado {
    @Id
    @Column(name = "id_resgatado")
    private Integer id;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Size(max = 10)
    @Column(name = "estado_saude")
    private String estadoSaude;

    @NotNull
    @Column(name = "data_hora_resgate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraResgate;

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

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEstadoSaude() { return estadoSaude; }
    public void setEstadoSaude(String estadoSaude) { this.estadoSaude = estadoSaude; }

    public Date getDataHoraResgate() { return dataHoraResgate; }
    public void setDataHoraResgate(Date dataHoraResgate) { this.dataHoraResgate = dataHoraResgate; }

    public Integer getDdd() { return ddd; }
    public void setDdd(Integer ddd) { this.ddd = ddd; }

    public String getNumeroCel() { return numeroCel; }
    public void setNumeroCel(String numeroCel) { this.numeroCel = numeroCel; }

    public Abrigo getAbrigo() { return abrigo; }
    public void setAbrigo(Abrigo abrigo) { this.abrigo = abrigo; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
}