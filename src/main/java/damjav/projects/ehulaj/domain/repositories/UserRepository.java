package damjav.projects.ehulaj.domain.repositories;

import damjav.projects.ehulaj.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET active = false WHERE id = ?",nativeQuery = true)
    void lockUserByUserId(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET active = true WHERE id = ?",nativeQuery = true)
    void unlockUserByUserId(Long id);

}
