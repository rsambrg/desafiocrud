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

import com.dnd.dndfr.model.Racas;
import com.dnd.dndfr.model.Skill;
import com.dnd.dndfr.service.RacasService;
import com.dnd.dndfr.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private RacasService racasService;

    @GetMapping
    public String getAllSkill(Model model){
        List<Skill> skill = skillService.getAllSkill();
        model.addAttribute("skill", skill);
        return "skill/list";

    }

    @GetMapping("/novo")
    public String showForm(Model model){
        model.addAttribute("skill", new Skill());
        model.addAttribute("racas", racasService.getAllRacas());
        return "skill/form";
    }

    @GetMapping("editar/{id}")
    public String showUpdateForm(@PathVariable("id")Long id, Model model){
        Skill skill = skillService.getSkillById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido" + id));
        model.addAttribute("skill",skill);
        return "skill/form";
    }

    @PostMapping("/salvar")
    public String salvarSkill(@ModelAttribute("skill") Skill skill, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("racas", racasService.listarRacas());
            return "skill/form";
        }

        List<Racas> racas = racasService.findByIds(skill.getRacasIds());
        skill.setRacas(racas);

        skillService.savSkill(skill);
        return "redirect:/skill";
    }

    @GetMapping("deletar/{id}")
    public String deleteSkill(@PathVariable("id")Long id){
        skillService.deleteSkill(id);
        return "redirect:/skill";
    }

    

    @GetMapping("/detalhes/{id}")
    public String detalhesskill(@PathVariable("id") Long id, Model model) {
        Skill skill = skillService.findById(id);
        if (skill != null) {
            model.addAttribute("skill", skill);
            return "skill/detalhes";
        } else {
            return "404"; 
        }
    }

}
