package damjav.projects.ehulaj.domain.repositories;


import damjav.projects.ehulaj.domain.entities.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    @Query(value = "SELECT * FROM problems ORDER BY reported DESC;",nativeQuery = true)
    List<Problem> findAllSortByAdded();

    @Modifying
    @Transactional
    @Query(value = "UPDATE problems SET status = 'Zakończono' WHERE id = ?",nativeQuery = true)
    void endReport(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM problems WHERE user_id = ?", nativeQuery = true)
    void deleteAllUserProblemsByUserId(Long id);





}
