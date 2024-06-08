package ma.cabinet.controller;

import ma.cabinet.entities.Secretaire;
import ma.cabinet.repository.ISecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/secretaires")
public class SecretaireController {

    @Autowired
    private ISecretaireRepository secretaireRepo;

    @GetMapping
    public String listSecretaires(Model model) {
        List<Secretaire> secretaires = secretaireRepo.findAll();
        model.addAttribute("secretaires", secretaires);
        return "secretaires";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("secretaire", new Secretaire());
        return "add-secretaire";
    }

    @PostMapping
    public String addSecretaire(@ModelAttribute Secretaire secretaire) {
        secretaireRepo.save(secretaire);
        return "redirect:/secretaires";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Secretaire> secretaire = secretaireRepo.findById(id);
        if (secretaire.isPresent()) {
            model.addAttribute("secretaire", secretaire.get());
            return "edit-secretaire";
        } else {
            return "redirect:/secretaires";
        }
    }

    @PostMapping("/update/{id}")
    public String updateSecretaire(@PathVariable Long id, @ModelAttribute Secretaire secretaire) {
        secretaire.setId(id);
        secretaireRepo.save(secretaire);
        return "redirect:/secretaires";
    }

    @GetMapping("/delete/{id}")
    public String deleteSecretaire(@PathVariable Long id) {
        secretaireRepo.deleteById(id);
        return "redirect:/secretaires";
    }
}
