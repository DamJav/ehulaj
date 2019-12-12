package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.domain.entities.Problem;
import damjav.projects.ehulaj.domain.entities.User;
import damjav.projects.ehulaj.domain.repositories.AdvertisementRepository;
import damjav.projects.ehulaj.domain.repositories.ProblemRepository;
import damjav.projects.ehulaj.domain.repositories.UserRepository;
import damjav.projects.ehulaj.services.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;
    private final AdvertisementRepository advertisementRepository;

    public AdminController(ProblemService problemService, ProblemRepository problemRepository, UserRepository userRepository, AdvertisementRepository advertisementRepository) {
        this.problemRepository = problemRepository;
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
    }

    @GetMapping("/reports")
    public String prepareReports(Model model){
        List<Problem> problems = problemRepository.findAllSortByAdded();
        model.addAttribute("problems", problems);
        return "/admin/reports";
    }

    @GetMapping("/reports/end")
    public String processEndReport(Long id){
        problemRepository.endReport(id);
        return "/admin/reports";
    }

    @GetMapping("/manage")
    public String adminManage(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/admin/manage";
    }

    @GetMapping("/manage/delete")
    public String deleteUser(Long id){
        advertisementRepository.deleteAllUserAdvertisementsByUserId(id);
        problemRepository.deleteAllUserProblemsByUserId(id);
        userRepository.deleteById(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/lock")
    public String lockUser(Long id){
        userRepository.lockUserByUserId(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/unlock")
    public String unlockUser(Long id){
        userRepository.unlockUserByUserId(id);
        return "redirect:/admin/manage";
    }

}
