package com.example.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.example.demo.models.Coach;
import com.example.demo.repositories.CoachRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CoachController {

    @Autowired
    private CoachRepository coachRepository;
    
    private final Path rootLocation = Paths.get("C:\\Users\\amine\\OneDrive\\Bureau\\demo\\src\\main\\resources\\static\\uploads\\coaches");

    
    @GetMapping("/coaches")
    public String index(final Model model) {
        List<Coach> coachs = this.coachRepository.findAll(); 
        model.addAttribute("coachs", coachs);

        return "coach/index";
    }
    @GetMapping("/coach")
    public String list(final Model model) {
        List<Coach> coachs = this.coachRepository.findAll();;
        model.addAttribute("coachs", coachs);

        return "coach/list";
    }

    @GetMapping("/coach-create")
    public String add() {
        return "coach/add";
    }

    @PostMapping("/coach")
    public String store(@RequestParam("nom") final String nom, @RequestParam("prenom") final String prenom, @RequestParam("specialite") final String specialite, @RequestParam("photo") final MultipartFile photo) throws Exception {
        String fileName = photo.getOriginalFilename();
        
        Files.copy(photo.getInputStream(), this.rootLocation.resolve(photo.getOriginalFilename()),  StandardCopyOption.REPLACE_EXISTING);

        Coach coach = new Coach(nom, prenom, specialite, fileName);
        this.coachRepository.save(coach);

        return "redirect:/coaches";
    }
    @GetMapping("/coach/{id}")

    public String deletecoach(@PathVariable Long id ) {

        this.coachRepository.deleteById(id);
        return "redirect:/coaches";


    }
    @GetMapping("/coach/edit/{id}")
    public String editActiviteForm(@PathVariable Long id , Model model ) {

        model.addAttribute("coach",this.coachRepository.getById(id));
        return "edit_coach";

    }
    @PostMapping("/coach/{id}")
    public String updatecoach(@PathVariable Long id ,
                                 @ModelAttribute("coach") Coach coach,
                                 Model model ) {
        Coach existingCoach =this.coachRepository.getById(id);
        existingCoach.setId(id);
        existingCoach.setNom(coach.getNom());
        existingCoach.setPrenom(coach.getPrenom());
        existingCoach.setSpecialite(coach.getSpecialite());
        existingCoach.setPhoto(coach.getPhoto());
        this.coachRepository.save(existingCoach);
        return "redirect:/coach";

    }
}
