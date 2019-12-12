package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.domain.entities.Advertisement;
import damjav.projects.ehulaj.domain.repositories.AdvertisementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/advertisements")
public class AllAdvertisementController {

    private final AdvertisementRepository advertisementRepository;

    public AllAdvertisementController(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @GetMapping("/showAll")
    public String showUserAdvertisement(Model model){
        List<Advertisement> advertisements =  advertisementRepository.findAllSortByAdded();
        model.addAttribute("listAd", advertisements);
        return "advertisement/show-all";
    }
}
