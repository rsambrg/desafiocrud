package com.dnd.dndfr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.dndfr.model.Localizacoes;
import com.dnd.dndfr.repository.LocalizacoesRepository;

@Service
public class LocalizacoesService {
    @Autowired
    private LocalizacoesRepository localizacoesRepository;

    public List<Localizacoes> getAllLocalizacoes() {
        return localizacoesRepository.findAll();
    }

    public Optional<Localizacoes> getLocalizacoesById(String codigoPostal) {
        return localizacoesRepository.findById(codigoPostal);
    }

    public Localizacoes salvarLocalizacoes(Localizacoes local) {
        return localizacoesRepository.save(local);
    }

    public void deletarLocalizacoes(String codigoPostal) {
        localizacoesRepository.deleteById(codigoPostal);
    }

    public List<String> listarLocalizacoes() {
        return localizacoesRepository.findAll().stream()
                .map(Localizacoes::getNomeLocal)
                .collect(Collectors.toList());
    }

    public List<Localizacoes> findByIds(List<String> codigosPostais) {
        return localizacoesRepository.findByCodigoPostalIn(codigosPostais);
    }

    public Localizacoes findById(Long id) {
        return localizacoesRepository.findById(id).orElse(null);
    }
}
