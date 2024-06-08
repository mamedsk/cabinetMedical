package ma.cabinet.controller;

import ma.cabinet.entities.Dentist;
import ma.cabinet.entities.DossierMedicale;
import ma.cabinet.entities.Patient;
import ma.cabinet.repository.IDentistRepository;
import ma.cabinet.repository.IDossierMedRepository;
import ma.cabinet.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DossierMedicaleController {

    @Autowired
    private IDossierMedRepository dossierRepo;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDentistRepository dentistRepository;

    @RequestMapping(value = "/dossiers", method = RequestMethod.GET)
    public String listDossiers(Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                               @RequestParam(name = "size", required = false, defaultValue = "10") int s) {
        List<DossierMedicale> dossiers = dossierRepo.findAll(PageRequest.of(p, s)).getContent();
        model.addAttribute("dossiers", dossiers);
        return "dossiers";
    }

    @RequestMapping(value = "/dossiers/form", method = RequestMethod.GET)
    public String formDossier(Model model) {

        List<Patient> patients = patientRepository.findAll();
        List<Dentist> dentists = dentistRepository.findAll();
        model.addAttribute("dossierMedicale", new DossierMedicale());
        model.addAttribute("patients", patients);
        model.addAttribute("dentists", dentists);

        return "add-dossier";
    }

    @RequestMapping(value = "/dossiers/save", method = RequestMethod.POST)
    public String saveDossier(@ModelAttribute DossierMedicale dossierMedicale, Model model) {
        dossierRepo.save(dossierMedicale);
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/dossiers/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<DossierMedicale> dossier = dossierRepo.findById(id);
        if (dossier.isPresent()) {
            model.addAttribute("dossierMedicale", dossier.get());
            return "edit-dossier";
        } else {
            return "redirect:/dossiers";
        }
    }

    @RequestMapping(value = "/dossiers/update/{id}", method = RequestMethod.POST)
    public String updateDossier(@PathVariable("id") Long id, @ModelAttribute DossierMedicale dossierMedicale) {
        dossierMedicale.setId(id);
        dossierRepo.save(dossierMedicale);
        return "redirect:/dossiers";
    }

    @RequestMapping(value = "/dossiers/delete/{id}", method = RequestMethod.GET)
    public String deleteDossier(@PathVariable("id") Long id) {
        dossierRepo.deleteById(id);
        return "redirect:/dossiers";
    }
}
