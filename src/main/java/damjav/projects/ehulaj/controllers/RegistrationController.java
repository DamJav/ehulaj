package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.dtos.RegistrationDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String getRegistrationPage(Model model){
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "register/form";
    }
}

