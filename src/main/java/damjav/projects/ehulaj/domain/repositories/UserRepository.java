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

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = ?2 WHERE username = ?1",nativeQuery = true)
    void changePasswordByUsername(String username, String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM users WHERE username = ?", nativeQuery = true)
    void deleteUserByName(String name);

    @Query(value = "SELECT id FROM users WHERE username = ?", nativeQuery = true)
            Long findIdByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "insert into users(email, password, username, active) values\n" +
            "('dga1999@wp.pl', '{noop}admin', 'admin', true);", nativeQuery = true)
    void createAdmin();

    @Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'admin',2);", nativeQuery = true)
    void makeAdminAdmin();


    @Transactional
    @Modifying
    @Query(value = "insert into users(email, password, username, active) values\n" +
            "('user@wp.pl', '{noop}user', 'user', true);", nativeQuery = true)
    void createUser();

    @Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'user',1);", nativeQuery = true)
    void makeUserUser();


}
