package damjav.projects.ehulaj.services.impl;


import damjav.projects.ehulaj.domain.entities.Advertisement;
import damjav.projects.ehulaj.domain.entities.Problem;
import damjav.projects.ehulaj.domain.entities.User;
import damjav.projects.ehulaj.domain.repositories.ProblemRepository;
import damjav.projects.ehulaj.domain.repositories.UserRepository;
import damjav.projects.ehulaj.dtos.ProblemDataDTO;
import damjav.projects.ehulaj.services.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultProblemService implements ProblemService {
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;

    public DefaultProblemService(UserRepository userRepository, ProblemRepository problemRepository) {
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
    }

    @Override
    public void addProblem(ProblemDataDTO problemDataDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Problem problem = mapper.map(problemDataDTO, Problem.class);
        problem.setUser(user);
        problem.setStatus("Rozpoczęto");
        problemRepository.save(problem);
    }
}
