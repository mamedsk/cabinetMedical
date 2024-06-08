package ma.cabinet.controller;

import ma.cabinet.entities.SituationFinancier;
import ma.cabinet.repository.ISituationFinancierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SituationFinancierController {

    @Autowired
    private ISituationFinancierRepository situationFinancierRepository;

    @RequestMapping(value = "/situation-financier")
    public String getAllSituationFinanciers(Model model,
                                            @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                                            @RequestParam(name = "size", required = false, defaultValue = "10") int s) {
        List<SituationFinancier> pageSituationFinanciers = situationFinancierRepository.findAll(PageRequest.of(p, s)).getContent();
        model.addAttribute("situationFinanciers", pageSituationFinanciers);
        return "situation-financier";
    }

    @RequestMapping(value = "/situation-financier/form", method = RequestMethod.GET)
    public String addSituationFinancierForm(Model model) {
        model.addAttribute("situationFinancier", new SituationFinancier());
        return "add-situation-financier";
    }

    @RequestMapping(value = "/situation-financier/save", method = RequestMethod.POST)
    public String addSituationFinancier(@ModelAttribute SituationFinancier situationFinancier) {
        situationFinancierRepository.save(situationFinancier);
        return "redirect:/situation-financier";
    }

    @RequestMapping(value = "/situation-financier/delete/{id}", method = RequestMethod.GET)
    public String deleteSituationFinancier(@PathVariable("id") Long id) {
        situationFinancierRepository.deleteById(id);
        return "redirect:/situation-financier";
    }

    @RequestMapping(value = "/situation-financier/edit/{id}", method = RequestMethod.GET)
    public String editSituationFinancierForm(@PathVariable Long id, Model model) {
        Optional<SituationFinancier> optionalSituationFinancier = situationFinancierRepository.findById(id);
        if (optionalSituationFinancier.isPresent()) {
            model.addAttribute("situationFinancier", optionalSituationFinancier.get());
            return "edit-situation-financier";
        } else {
            return "redirect:/situation-financier";
        }
    }

    @RequestMapping(value = "/situation-financier/update/{id}", method = RequestMethod.POST)
    public String editSituationFinancier(@PathVariable Long id, @ModelAttribute SituationFinancier updatedSituationFinancier) {
        Optional<SituationFinancier> optionalSituationFinancier = situationFinancierRepository.findById(id);
        if (optionalSituationFinancier.isPresent()) {
            SituationFinancier situationFinancier = optionalSituationFinancier.get();
            // Update relevant fields of the entity here
            situationFinancierRepository.save(situationFinancier);
        }
        return "redirect:/situation-financier";
    }
}
