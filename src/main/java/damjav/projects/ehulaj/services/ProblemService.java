package damjav.projects.ehulaj.services;

import damjav.projects.ehulaj.domain.entities.User;
import damjav.projects.ehulaj.dtos.ProblemDataDTO;

public interface ProblemService {
    void addProblem(ProblemDataDTO problemDataDTO);

}
