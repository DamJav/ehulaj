package damjav.projects.ehulaj.services;

import damjav.projects.ehulaj.dtos.AdvertisementDataDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AdvertisementService {
    void createAdvertisement(AdvertisementDataDTO advertisementDataDTO);

}
