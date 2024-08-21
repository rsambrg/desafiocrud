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

import com.dnd.dndfr.model.Npc;
import com.dnd.dndfr.model.Racas;
import com.dnd.dndfr.service.NpcService;
import com.dnd.dndfr.service.RacasService;

@Controller
@RequestMapping("/npc")
public class NpcController {
    @Autowired
    private NpcService npcService;
    @Autowired
    private RacasService racasService;

    @GetMapping
    public String getAllNpc(Model model){
        List<Npc> npc = npcService.getAllNpc();
        model.addAttribute("npc", npc);
        return "npc/list";
    }

    @GetMapping("/novo")
    public String showForm(Model model){
        model.addAttribute("npc", new Npc());
        model.addAttribute("racas", racasService.getAllRacas());
        return "npc/form";
    }
    
    @GetMapping("editar/{id}")
    public String showUpdateForm(@PathVariable("id")Long id, Model model){
        Npc npc = npcService.getNpcById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido" + id));
        model.addAttribute("npc",npc);
        return "npc/form";
    }

    @PostMapping("/salvar")
    public String salvarNpc(@ModelAttribute("npc") Npc npc, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("racas", racasService.listarRacas());
            return "npc/form";
        }

        List<Racas> racas = racasService.findByIds(npc.getRacasIds());
        npc.setRacas(racas);

        npcService.savNpc(npc);
        return "redirect:/npc";
    }

    @GetMapping("deletar/{id}")
    public String deleteNpc(@PathVariable("id")Long id){
        npcService.deleteNpc(id);
        return "redirect:/npc";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesNpc(@PathVariable("id") Long id, Model model) {
        Npc npc = npcService.findById(id); 
        if (npc != null) {
            model.addAttribute("npc", npc);
            return "npc/detalhes";
        } else {
            return "404"; 
        }
    }
}
