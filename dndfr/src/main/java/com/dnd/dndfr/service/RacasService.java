package com.dnd.dndfr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.dndfr.model.Racas;
import com.dnd.dndfr.repository.RacasRepository;

@Service
public class RacasService {
    @Autowired
    private RacasRepository racasRepository;

    public List<Racas> getAllRacas(){
        return racasRepository.findAll();
    }

    public Optional<Racas> getRacasById(Long id){
        return racasRepository.findById(id);
    }

    public Racas savRacas(Racas racas){
        return racasRepository.save(racas);
    }

    public void deleteRacas(Long id){
        racasRepository.deleteById(id);
    }

    public List<String> listarRacas() {
        return racasRepository.findAll().stream()
                .map(Racas::getNome)
                .collect(Collectors.toList());
    }

    public List<Racas> findByIds(List<Long> ids) {
        return racasRepository.findByIdIn(ids);
    }
    
    public Racas findById(Long id) {
        return racasRepository.findById(id).orElse(null);
    }
}
