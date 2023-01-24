package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Offre;
import com.example.demo.repositories.OffreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OffreController {
    
    @Autowired
    private OffreRepository offreRepository;

    @GetMapping("/offres")
    public String index(final Model model) {
        List<Offre> offres = this.offreRepository.findAll();
        model.addAttribute("offres", offres);

        return "offre/index";
    }

    @GetMapping("/offre-create")
    public String add() {
        return "offre/add";
    }

    public String store(@RequestParam("tarif") final String tarif, @RequestParam("periode") final String periode) {
        Offre offre = new Offre(tarif, periode);
        this.offreRepository.save(offre);
        
        return "redirect:/offres";
    }
}
