package com.dnd.dndfr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.dndfr.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Object> {
    // SAVE() findById(), findAll(), deleteById()
}
