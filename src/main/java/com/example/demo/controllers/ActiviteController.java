package com.example.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.example.demo.models.Activite;
import com.example.demo.models.Coach;
import com.example.demo.repositories.ActiviteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ActiviteController {
    
    private final Path rootLocation = Paths.get("C:\\Users\\amine\\OneDrive\\Bureau\\demo\\src\\main\\resources\\static\\uploads\\activities");

    @Autowired
    private ActiviteRepository activiteRepository;

    @GetMapping("/activite/activitegest")
    public String activitegest(final Model model) {
        List<Activite> activites = this.activiteRepository.findAll();;
        model.addAttribute("activities", activites);

        return "activite/activitegest";
    }
    @GetMapping("/activite")
    public String index(final Model model) {
        List<Activite> activites = this.activiteRepository.findAll();; 
        model.addAttribute("activities", activites);

        return "activite/index";
    }

    @GetMapping("/activite-create")
    public String add() {
        return "activite/add";
    }


    @PostMapping("/activite")
    public String store(@RequestParam("libelle") final String libelle, @RequestParam("description") final String description, @RequestParam("image") MultipartFile image) throws Exception {
        String fileName = image.getOriginalFilename();
        fileName = "/uploads/activities/" + fileName;
        
        Files.copy(image.getInputStream(), this.rootLocation.resolve(image.getOriginalFilename()),  StandardCopyOption.REPLACE_EXISTING);

        Activite activite = new Activite(libelle, description, fileName);
        this.activiteRepository.save(activite);

        return "redirect:/activite/activitegest";
    }


}
