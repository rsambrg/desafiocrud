package com.dnd.dndfr.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class Npc {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String classe;
    private String descricao;

    @Transient
    private List<Long> racasIds;

    @ManyToMany
    @JoinTable(
        name = "npc_racas",
        joinColumns = @JoinColumn(name = "npc_id"),
        inverseJoinColumns = @JoinColumn(name = "raca_id")
    )
    private List<Racas> racas;

    public List<Racas> getRacas() {
        return racas;
    }

    public void setRacas(List<Racas> racas) {
        this.racas = racas;
    }

    public List<Long> getRacasIds() {
        return racasIds;
    }

    public void setRacasIds(List<Long> racasIds) {
        this.racasIds = racasIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    
}
