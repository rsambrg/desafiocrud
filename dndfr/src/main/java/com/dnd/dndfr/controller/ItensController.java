package com.dnd.dndfr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnd.dndfr.model.Itens;
import com.dnd.dndfr.service.ItensService;

@Controller
@RequestMapping("/itens")
public class ItensController {
    @Autowired
    private ItensService itensService;

    @GetMapping
    public String getAllItens(Model model){
        List<Itens> itens = itensService.getAllItens();
        model.addAttribute("itens", itens);
        return "itens/list";
    }

    @GetMapping("/novo")
    public String showForm (Model model){
        model.addAttribute("itens", new Itens());
        return "itens/form";
    }

    @GetMapping("editar/{id}")
    public String showUpdateForm(@PathVariable("id")Long id, Model model){
        Itens itens = itensService.getItensById(id).orElseThrow(() -> new IllegalArgumentException("Id invalido" + id));
        model.addAttribute("itens", itens);
        return "itens/form";
    }

    @PostMapping("/salvar")
    public String salvarItens(Itens itens){
        itensService.savItens(itens);
        return "redirect:/itens";
    }

    @GetMapping("deletar/{id}")
    public String deleteItens(@PathVariable("id")Long id){
        itensService.deleteItens(id);
        return "redirect:/itens";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesNpc(@PathVariable("id") Long id, Model model) {
        Itens itens = itensService.findById(id); 
        if (itens != null) {
            model.addAttribute("itens", itens);
            return "itens/detalhes";
        } else {
            return "404"; 
        }
    }


}
