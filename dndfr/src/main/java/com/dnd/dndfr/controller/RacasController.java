package com.dnd.dndfr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnd.dndfr.model.Localizacoes;
import com.dnd.dndfr.model.Racas;
import com.dnd.dndfr.service.LocalizacoesService;
import com.dnd.dndfr.service.RacasService;



@Controller
@RequestMapping("/racas")
public class RacasController {
    @Autowired
    private RacasService racasService;
    @Autowired
    private LocalizacoesService localizacoesService;

    @GetMapping
    public String getAllRacas(Model model){
        List<Racas> racas = racasService.getAllRacas();
        model.addAttribute("racas", racas);
        return "racas/list";
    }

    @GetMapping("/novo")
    public String showForm(Model model) {
        model.addAttribute("racas",new Racas());
        model.addAttribute("localizacoes",localizacoesService.getAllLocalizacoes());
        return "racas/form";
    }

    @GetMapping("editar/{id}")
    public String showUpdateForm(@PathVariable("id")Long id, Model model) {
        Racas racas = racasService.getRacasById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido" + id));
        model.addAttribute("racas",racas);
        return "racas/form";
    }

    @PostMapping("/salvar")
    public String salvarRacas(@ModelAttribute("racas") Racas racas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("localizacoes", localizacoesService.listarLocalizacoes());
            return "racas/form";
        }

        List<Localizacoes> localizacoes = localizacoesService.findByIds(racas.getLocalIds());
        racas.setLocalizacoes(localizacoes);

        racasService.savRacas(racas);
        return "redirect:/racas";
    }
    
    @GetMapping("deletar/{id}")
    public String deleteRacas(@PathVariable("id")Long id) {
        racasService.deleteRacas(id);
        return "redirect:/racas";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesracas(@PathVariable("id") Long id, Model model) {
        Racas racas = racasService.findById(id); 
        if (racas != null) {
            model.addAttribute("racas", racas);
            return "racas/detalhes";
        } else {
            return "404"; 
        }
    }
    
    
}
