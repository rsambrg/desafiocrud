package com.dnd.dndfr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.dndfr.model.Racas;

@Repository
public interface  RacasRepository extends  JpaRepository<Racas, Object>{
    List<Racas> findByIdIn(List<Long> ids);
}
