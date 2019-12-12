package damjav.projects.ehulaj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/more")
public class MoreController {

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
