package com.dnd.dndfr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnd.dndfr.model.Itens;
import com.dnd.dndfr.model.Localizacoes;
import com.dnd.dndfr.model.Npc;
import com.dnd.dndfr.model.Racas;
import com.dnd.dndfr.model.Skill;
import com.dnd.dndfr.service.ItensService;
import com.dnd.dndfr.service.LocalizacoesService;
import com.dnd.dndfr.service.NpcService;
import com.dnd.dndfr.service.RacasService;
import com.dnd.dndfr.service.SkillService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private NpcService npcService;
    @Autowired
    private ItensService itensService;
    @Autowired
    private LocalizacoesService localizacoesService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private RacasService racasService;

    @GetMapping
    public String home(Model model){
        List<Npc> npcs = npcService.getAllNpc();
        List<Itens> itens = itensService.getAllItens();
        List<Localizacoes> local = localizacoesService.getAllLocalizacoes();
        List<Skill> skill = skillService.getAllSkill();
        List<Racas> racas = racasService.getAllRacas();

        model.addAttribute("npcs",npcs);
        model.addAttribute("itens", itens);
        model.addAttribute("localizacoes", local);
        model.addAttribute("skill",skill);
        model.addAttribute("racas",racas);

        return "home/home";
    }

    
}
