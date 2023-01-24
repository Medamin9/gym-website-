package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Salle;
import com.example.demo.repositories.SalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalleController {
    
    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/salles")
    public String index(final Model model) {
        List<Salle> salles = this.salleRepository.findAll();
        model.addAttribute("salles", salles);
        return "salle/index";
    }

    @GetMapping("/salle-create")
    public String add() {
        return "salle/add";
    }

    @PostMapping("/salle")
    public String store(@RequestParam("nom") final String nom, @RequestParam("telephone") final String telephone) {
        Salle salle = new Salle(nom, telephone);
        this.salleRepository.save(salle);
        return "redirect:/salles";
    }
}
