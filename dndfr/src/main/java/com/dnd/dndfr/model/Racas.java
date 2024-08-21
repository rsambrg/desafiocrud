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
public class Racas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String aparencia;

    @Transient
    private List<String> localIds;

    public List<String> getLocalIds() {
        return localIds;
    }
    public void setLocalIds(List<String> localIds) {
        this.localIds = localIds;
    }

    @ManyToMany
    @JoinTable(
        name = "racas_localizacoes",
        joinColumns = @JoinColumn(name = "raca_id"),
        inverseJoinColumns = @JoinColumn(name = "codigo_postal")
    )
    private List<Localizacoes> localizacoes;

    
    
    public List<Localizacoes> getLocalizacoes() {
        return localizacoes;
    }
    public void setLocalizacoes(List<Localizacoes> localizacoes) {
        this.localizacoes = localizacoes;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getAparencia() {
        return aparencia;
    }
    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
