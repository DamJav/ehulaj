package damjav.projects.ehulaj.controllers;


import com.sun.xml.bind.v2.schemagen.xmlschema.Particle;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String getHomePage(){
        return "index";
    }
}
