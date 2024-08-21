package com.dnd.dndfr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.dndfr.model.Itens;
import com.dnd.dndfr.repository.ItensRepository;

@Service
public class ItensService {
    @Autowired
    private ItensRepository itensRepository;

    public List<Itens> getAllItens(){
        return itensRepository.findAll();
    }

    public Optional<Itens> getItensById(Long id){
        return itensRepository.findById(id);
    }

    public Itens savItens(Itens itens){
        return itensRepository.save(itens);
    }

    public void deleteItens(Long id){
        itensRepository.deleteById(id);
    }

    public Itens findById(Long id) {
        return itensRepository.findById(id).orElse(null);
    }


}
