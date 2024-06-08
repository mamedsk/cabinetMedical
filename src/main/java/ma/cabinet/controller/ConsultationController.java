package ma.cabinet.controller;

import ma.cabinet.entities.Consultation;
import ma.cabinet.entities.DossierMedicale;
import ma.cabinet.repository.IConsultationRepository;
import ma.cabinet.repository.IDossierMedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ConsultationController {

    @Autowired
    private IConsultationRepository consultationRepo;
    @Autowired
    private IDossierMedRepository dossierMedRepository;

    @RequestMapping(value = "/consultations", method = RequestMethod.GET)
    public String listConsultations(Model model,
                                    @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                                    @RequestParam(name = "size", required = false, defaultValue = "10") int s) {
        List<Consultation> consultations = consultationRepo.findAll(PageRequest.of(p, s)).getContent();
        model.addAttribute("consultations", consultations);
        return "consultations";
    }

    @RequestMapping(value = "/consultations/form", method = RequestMethod.GET)
    public String formConsultation(Model model) {
        List<DossierMedicale> dossierMedicale = dossierMedRepository.findAll();

        model.addAttribute("consultation", new Consultation());
        model.addAttribute("dossiers", dossierMedicale);
        return "add-consultation";
    }

    @RequestMapping(value = "/consultations/save", method = RequestMethod.POST)
    public String saveConsultation(@ModelAttribute Consultation consultation, Model model) {
        Optional<DossierMedicale> dossierMedicale = dossierMedRepository.findById(consultation.getDossierMedicale().getId());
        consultationRepo.save(consultation);
        return "redirect:/consultations";
    }

    @RequestMapping(value = "/consultations/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Consultation> consultation = consultationRepo.findById(id);
        if (consultation.isPresent()) {
            model.addAttribute("consultation", consultation.get());
            return "edit-consultation";
        } else {
            return "redirect:/consultations";
        }
    }

    @RequestMapping(value = "/consultations/update/{id}", method = RequestMethod.POST)
    public String updateConsultation(@PathVariable("id") Long id, @ModelAttribute Consultation consultation) {
        consultation.setId(id);
        consultationRepo.save(consultation);
        return "redirect:/consultations";
    }

    @RequestMapping(value = "/consultations/delete/{id}", method = RequestMethod.GET)
    public String deleteConsultation(@PathVariable("id") Long id) {
        consultationRepo.deleteById(id);
        return "redirect:/consultations";
    }
}
