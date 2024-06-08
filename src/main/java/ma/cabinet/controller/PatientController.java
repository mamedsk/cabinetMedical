package ma.cabinet.controller;

import ma.cabinet.entities.Patient;
import ma.cabinet.enums.Mutuelle;
import ma.cabinet.repository.IPatientRepository;
import ma.cabinet.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class PatientController {

    @Autowired
    private IPatientRepository patientRepo;


    @Autowired
    private PatientService patientService =new PatientService();

    @RequestMapping(value = "/patient")
    public String patient(Model model ,
                          @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                          @RequestParam(name ="size", required = false, defaultValue = "10") int s){

        List<Patient> pagepatients = patientRepo.findAll(PageRequest.of(p,s)).getContent();
        model.addAttribute("patientlist",pagepatients);
        return "patients";
    }

    @RequestMapping(value = "/patient/form",method = RequestMethod.GET)
    public String formpatient(Model model){

        model.addAttribute("patient",new Patient());
        return "addPatient";
    }

    @RequestMapping(value = "/patient/save",method = RequestMethod.POST)
    public String save(Model model,Patient patient){

        patientService.addPatient(patient);
        //patientRepo.save(patient);
        return "addPatient";
    }

    @RequestMapping(value = "/patient/edit/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patientOptional = patientRepo.findById(id);
        if (patientOptional.isPresent()) {
            model.addAttribute("patient", patientOptional.get());
            return "updatePatient";
        } else {
            return "redirect:/patient";
        }
    }

    @RequestMapping(value = "/patient/update", method = RequestMethod.POST)
    public String updatePatient(@ModelAttribute Patient patient) {
        patientRepo.save(patient);
        return "redirect:/patient";
    }


    @RequestMapping(value = "/patient/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {

        patientRepo.deleteById(id);
        return "redirect:/patient";
    }

}
