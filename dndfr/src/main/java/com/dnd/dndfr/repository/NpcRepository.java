package com.dnd.dndfr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.dndfr.model.Npc;

@Repository
public interface  NpcRepository extends JpaRepository<Npc, Object> {
    // SAVE() findById(), findAll(), deleteById()
}
