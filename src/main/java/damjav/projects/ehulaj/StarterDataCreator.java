package damjav.projects.ehulaj;


import damjav.projects.ehulaj.domain.entities.Role;
import damjav.projects.ehulaj.domain.repositories.RoleRepository;
import damjav.projects.ehulaj.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("heroku") @Slf4j @RequiredArgsConstructor
public class StarterDataCreator implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        createRoles();
    }

    private void createRoles() {
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        userRepository.createAdmin();
        userRepository.makeAdminAdmin();
    }
}