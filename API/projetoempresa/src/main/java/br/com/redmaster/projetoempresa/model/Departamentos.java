package br.com.redmaster.projetoempresa.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamentos {
    @Id
    @Column(name = "numero_id")
    private int numeroId;

    @OneToMany(mappedBy = "departamentos", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("departamentos")
    private List<Funcionarios> listaFuncionarios;

    public List<Funcionarios> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionarios> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    @Column(name = "nome")
    private String nome;

    @Column(name = "andar")
    private int andar;

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
}
