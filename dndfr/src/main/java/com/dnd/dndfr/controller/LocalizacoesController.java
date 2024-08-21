package com.dnd.dndfr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnd.dndfr.model.Localizacoes;
import com.dnd.dndfr.service.LocalizacoesService;

@Controller
@RequestMapping("/local")
public class LocalizacoesController {

    @Autowired
    private LocalizacoesService localizacoesService;

    @GetMapping
    public String getAllLocalizacoes(Model model) {
        List<Localizacoes> local = localizacoesService.getAllLocalizacoes();
        model.addAttribute("localizacoes", local);
        return "local/list";
    }

    @GetMapping("/novo")
    public String showForm(Model model) {
        model.addAttribute("local", new Localizacoes());
        return "local/form";
    }

    @GetMapping("/editar/{codigoPostal}")
    public String showUpdateForm(@PathVariable("codigoPostal") String codigoPostal, Model model) {
        Localizacoes local = localizacoesService.getLocalizacoesById(codigoPostal)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + codigoPostal));
        model.addAttribute("local", local);
        return "local/form"; 
    }

    @PostMapping("/salvar")
    public String salvarLocalizacoes(@ModelAttribute("local") Localizacoes local) {
        localizacoesService.salvarLocalizacoes(local);
        return "redirect:/local";
    }

    @GetMapping("/deletar/{codigoPostal}")
    public String deleteLocalizacoes(@PathVariable("codigoPostal") String codigoPostal) {
        localizacoesService.deletarLocalizacoes(codigoPostal);
        return "redirect:/local";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesNpc(@PathVariable("id") Long id, Model model) {
        Localizacoes localizacoes = localizacoesService.findById(id); 
        if (localizacoes != null) {
            model.addAttribute("localizacoes", localizacoes);
            return "local/detalhes";
        } else {
            return "404"; 
        }
    }
    
}
