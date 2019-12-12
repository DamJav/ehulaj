package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.domain.entities.User;
import damjav.projects.ehulaj.domain.repositories.AdvertisementRepository;
import damjav.projects.ehulaj.domain.repositories.ProblemRepository;
import damjav.projects.ehulaj.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class AccountController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProblemRepository problemRepository;
    private final AdvertisementRepository advertisementRepository;

    public AccountController(UserRepository userRepository, PasswordEncoder passwordEncoder, ProblemRepository problemRepository, AdvertisementRepository advertisementRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.problemRepository = problemRepository;
        this.advertisementRepository = advertisementRepository;
    }


    @GetMapping
    public String prepareAccountPage(){
        return "/user/account";
    }

    @GetMapping("/passwordChange")
    public String preparePasswordChange(){
        return "user/change-password";
    }

    @PostMapping("/passwordChange")
    public String processPasswordChange(String password, Principal principal){
        String username = principal.getName();
        userRepository.changePasswordByUsername(username, passwordEncoder.encode(password));
        return "redirect:/login";
    }

    @GetMapping("/deleteAccount")
    public String prepareDeleteAccount(){
        return "user/delete-account";
    }

    @GetMapping("/deleteAccountUser")
    public String processDeleteAccount(Principal principal){
        String username = principal.getName();
        Long userId = userRepository.findIdByUsername(username);
        advertisementRepository.deleteAllUserAdvertisementsByUserId(userId);
        problemRepository.deleteAllUserProblemsByUserId(userId);
        userRepository.deleteById(userId);
        return "redirect:/login";
    }


}
