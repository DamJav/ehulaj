package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.dtos.AdvertisementDataDTO;
import damjav.projects.ehulaj.dtos.RegistrationDataDTO;
import damjav.projects.ehulaj.services.AdvertisementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/advertisement")
public class CreateAdvertisementController {

    private final AdvertisementService advertisementService;

    public CreateAdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/add")
    public String prepareAddAdvertisement(Model model){
        model.addAttribute("advertisementData", new AdvertisementDataDTO());
        return "advertisement/add";
    }

    @PostMapping("/add")
    public String processAddAdvertisement(@ModelAttribute("advertisementData") @Valid AdvertisementDataDTO advertisementData,
    BindingResult results){
        if (results.hasErrors()) {
            return "advertisement/add";
        }
        advertisementService.createAdvertisement(advertisementData);
        return "redirect:/user/advertisement/show";
    }

}
