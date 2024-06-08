package ma.cabinet.controller;

import ma.cabinet.entities.Dentist;
import ma.cabinet.entities.Patient;
import ma.cabinet.enums.Disponibilite;
import ma.cabinet.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class DentistController {

    @Autowired
    private IDentistRepository dentistRepository;

    @RequestMapping(value = "/dentist")
    public String dentist(Model model ,
                          @RequestParam(name = "page", required = false, defaultValue = "0") int p,
                          @RequestParam(name ="size", required = false, defaultValue = "10") int s){

        List<Dentist> pagedentists = dentistRepository.findAll(PageRequest.of(p,s)).getContent();
        model.addAttribute("pagedentists",pagedentists);
        return "dentist";
    }

    @RequestMapping(value = "/dentist/form",method = RequestMethod.GET)
    public String formdentist(Model model){

        model.addAttribute("dentist",new Dentist());
        return "addDentist";
    }
    public Disponibilite getDisponibiliteForDay(String day) {
        // Here you would implement your logic to determine the disponibilite for the given day
        // This could involve querying a database, accessing a service, or any other relevant operation in your application
        // For demonstration purposes, let's assume you have a predefined mapping of day to disponibilite

        switch (day) {
            case "Matin":
                return Disponibilite.Matin;
            case "Apres_midi":
                return Disponibilite.Apres_midi;
            case "Toute_La_Journee":
                return Disponibilite.Toute_La_Journee;
            // Add cases for other days as needed
            default:
                return null;
        }
    }


    @RequestMapping(value = "/dentist/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("dentist") Dentist dentist, @RequestParam("selectedDisponibilite") List<String> selectedDisponibilite) {

        Map<DayOfWeek, Disponibilite> disponibiliteMap = new HashMap<>();
        for (String day : selectedDisponibilite) {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);
            // Assuming you have a method to get Disponibilite based on user input, adjust this accordingly
            Disponibilite disponibilite = getDisponibiliteForDay(day);
            disponibiliteMap.put(dayOfWeek, disponibilite);
        }
        dentist.setDisponibilite(disponibiliteMap);


        return "redirect:/dentist/form";
    }


    @RequestMapping(value = "/dentist/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {

        dentistRepository.deleteById(id);
        return "redirect:/dentist";
    }


}
