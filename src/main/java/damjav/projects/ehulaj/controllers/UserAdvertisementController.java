package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.domain.entities.Advertisement;
import damjav.projects.ehulaj.domain.repositories.AdvertisementRepository;
import damjav.projects.ehulaj.dtos.AdvertisementDataDTO;
import damjav.projects.ehulaj.services.AdvertisementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user/advertisement")
public class UserAdvertisementController {

    private final AdvertisementService advertisementService;
    private final AdvertisementRepository advertisementRepository;

    public UserAdvertisementController(AdvertisementService advertisementService, AdvertisementRepository advertisementRepository) {
        this.advertisementService = advertisementService;
        this.advertisementRepository = advertisementRepository;

    }

    @GetMapping("/show")
    public String showUserAdvertisement(Principal principal, Model model){
        String username = principal.getName();
        List<Advertisement> advertisements =  advertisementRepository.findAllByUserUsername(username);
        model.addAttribute("listAd", advertisements);
        return "advertisement/user";
    }



    @GetMapping("/delete")
    public String deleteAdvertisement(Long id){
        Advertisement advertisement = advertisementRepository.findById(id).get();
        if(advertisement != null){
            advertisementRepository.delete(advertisement);
        }
        return "redirect:/user/advertisement/show";
    }

    @GetMapping("/update")
    public String prepareUpdateAdvertisement(Long id, Model model){
        Advertisement advertisement = advertisementRepository.findById(id).get();
        model.addAttribute("advertisementData", advertisement);
        return "advertisement/update";
    }
    @PostMapping("/update")
    public String processUpdateUserPage(@ModelAttribute("advertisementData") @Valid AdvertisementDataDTO advertisementDataDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "advertisement/add";
        }
        advertisementService.createAdvertisement(advertisementDataDTO);
        return "redirect:/user/advertisement/show";
    }

}
