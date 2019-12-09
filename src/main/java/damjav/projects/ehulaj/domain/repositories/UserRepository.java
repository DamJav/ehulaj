package damjav.projects.ehulaj.domain.repositories;

import damjav.projects.ehulaj.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
