package ma.cabinet.controller;

import ma.cabinet.entities.Role;
import ma.cabinet.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleRepository roleRepo;

    @GetMapping
    public String listRoles(Model model) {
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("role", new Role());
        return "add-role";
    }

    @PostMapping
    public String addRole(@ModelAttribute Role role) {
        roleRepo.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Role> role = roleRepo.findById(id);
        if (role.isPresent()) {
            model.addAttribute("role", role.get());
            return "edit-role";
        } else {
            return "redirect:/roles";
        }
    }

    @PostMapping("/update/{id}")
    public String updateRole(@PathVariable Long id, @ModelAttribute Role role) {
        role.setId(id);
        roleRepo.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleRepo.deleteById(id);
        return "redirect:/roles";
    }
}
