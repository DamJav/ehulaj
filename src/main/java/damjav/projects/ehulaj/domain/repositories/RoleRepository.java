package damjav.projects.ehulaj.domain.repositories;

import damjav.projects.ehulaj.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);

}
