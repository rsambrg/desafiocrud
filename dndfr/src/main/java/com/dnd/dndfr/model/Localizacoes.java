package com.dnd.dndfr.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Localizacoes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String codigoPostal;
    private String nomeLocal;
    private String descLocal;
    private String histLocal;

    @ManyToMany(mappedBy = "localizacoes")
    private List<Racas> racas;

    public List<Racas> getRacas() {
        return racas;
    }

    public void setRacas(List<Racas> racas) {
        this.racas = racas;
    }

    public String getHistLocal() {
        return histLocal;
    }

    public void setHistLocal(String histLocal) {
        this.histLocal = histLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getDescLocal() {
        return descLocal;
    }

    public void setDescLocal(String descLocal) {
        this.descLocal = descLocal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

}
