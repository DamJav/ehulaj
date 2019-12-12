package damjav.projects.ehulaj.domain.repositories;

import damjav.projects.ehulaj.domain.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByUserUsername(String username);

    @Query(value = "SELECT * FROM advertisements ORDER BY added DESC;",nativeQuery = true)
    List<Advertisement> findAllSortByAdded();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM advertisements WHERE user_id = ?", nativeQuery = true)
    void deleteAllUserAdvertisementsByUserId(Long id);


}
