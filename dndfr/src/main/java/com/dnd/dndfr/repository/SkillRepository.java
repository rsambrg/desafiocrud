package com.dnd.dndfr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.dndfr.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Object> {
    
}
