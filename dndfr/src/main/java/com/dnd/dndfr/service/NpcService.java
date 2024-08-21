package com.dnd.dndfr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.dndfr.model.Npc;
import com.dnd.dndfr.repository.NpcRepository;

@Service
public class NpcService {
    @Autowired
    private NpcRepository npcRepository;

    public List<Npc> getAllNpc(){
        return npcRepository.findAll();
    }

    public Optional<Npc> getNpcById(Long id){
        return npcRepository.findById(id);
    }

    public Npc savNpc(Npc npc){
        return npcRepository.save(npc);
    }

    public void deleteNpc(Long id){
        npcRepository.deleteById(id);
    }

    public Npc findById(Long id) {
        return npcRepository.findById(id).orElse(null);
    }
    
}
