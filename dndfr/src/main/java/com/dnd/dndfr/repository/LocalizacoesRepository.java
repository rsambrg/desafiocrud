package com.dnd.dndfr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.dndfr.model.Localizacoes;

@Repository
public interface LocalizacoesRepository extends JpaRepository<Localizacoes, Object> {
    List<Localizacoes> findByCodigoPostalIn(List<String> codigosPostais);
}
