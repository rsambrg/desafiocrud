package com.dnd.dndfr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.dndfr.model.Skill;
import com.dnd.dndfr.repository.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }
    
    public Optional<Skill> getSkillById(Long id){
        return skillRepository.findById(id);
    }

    public Skill savSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long id){
        skillRepository.deleteById(id);
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
