package damjav.projects.ehulaj.controllers;


import damjav.projects.ehulaj.dtos.AdvertisementDataDTO;
import damjav.projects.ehulaj.dtos.ProblemDataDTO;
import damjav.projects.ehulaj.services.ProblemService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/add")
    public String addProblem(Model model){
        model.addAttribute("problemData", new ProblemDataDTO());
        return "problems/add-problem";
    }

    @PostMapping("/add")
    public String progressAddProblem(@ModelAttribute("problemData") @Valid ProblemDataDTO problemData,
                                     BindingResult results){
        if (results.hasErrors()) {
            return "problems/add-problem";
        }
        problemService.addProblem(problemData);
        return "problems/home-problem";

    }
}
