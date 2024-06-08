package ma.cabinet.controller;

import ma.cabinet.entities.Facture;
import ma.cabinet.repository.IFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FactureController {

    @Autowired
    private IFactureRepository factureRepository;

    @RequestMapping(value = "/factures")
    public String getAllFactures(Model model,
                                 @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                                 @RequestParam(name = "size", required = false, defaultValue = "10") int s) {
        List<Facture> pageFactures = factureRepository.findAll(PageRequest.of(p, s)).getContent();
        model.addAttribute("factures", pageFactures);
        return "factures";
    }

    @RequestMapping(value = "/factures/form", method = RequestMethod.GET)
    public String addFactureForm(Model model) {
        model.addAttribute("facture", new Facture());
        return "add-facture";
    }

    @RequestMapping(value = "/factures/save", method = RequestMethod.POST)
    public String addFacture(@ModelAttribute Facture facture) {
        factureRepository.save(facture);
        return "redirect:/factures";
    }

    @RequestMapping(value = "/factures/delete/{id}", method = RequestMethod.GET)
    public String deleteFacture(@PathVariable("id") Long id) {
        factureRepository.deleteById(id);
        return "redirect:/factures";
    }

    @RequestMapping(value = "/factures/edit/{id}", method = RequestMethod.GET)
    public String editFactureForm(@PathVariable Long id, Model model) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            model.addAttribute("facture", optionalFacture.get());
            return "edit-facture";
        } else {
            return "redirect:/factures";
        }
    }

    @RequestMapping(value = "/factures/update/{id}", method = RequestMethod.POST)
    public String editFacture(@PathVariable Long id, @ModelAttribute Facture updatedFacture) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            Facture facture = optionalFacture.get();
            facture.setMontantTotal(updatedFacture.getMontantTotal());
            facture.setDateFacture(updatedFacture.getDateFacture());
            facture.setMontantTotal(updatedFacture.getMontantTotal());
            facture.setTypePaiement(updatedFacture.getTypePaiement());
            factureRepository.save(facture);
        }
        return "redirect:/factures";
    }
}
