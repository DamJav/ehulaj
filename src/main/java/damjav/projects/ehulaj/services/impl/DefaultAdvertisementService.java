package damjav.projects.ehulaj.services.impl;

import damjav.projects.ehulaj.domain.entities.Advertisement;
import damjav.projects.ehulaj.domain.entities.User;
import damjav.projects.ehulaj.domain.repositories.AdvertisementRepository;
import damjav.projects.ehulaj.domain.repositories.UserRepository;
import damjav.projects.ehulaj.dtos.AdvertisementDataDTO;
import damjav.projects.ehulaj.services.AdvertisementService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultAdvertisementService implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserRepository userRepository;

    public DefaultAdvertisementService(AdvertisementRepository advertisementRepository, UserRepository userRepository) {
        this.advertisementRepository = advertisementRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createAdvertisement(AdvertisementDataDTO advertisementDataDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Advertisement advertisement = mapper.map(advertisementDataDTO, Advertisement.class);
        advertisement.setUser(user);
        advertisementRepository.save(advertisement);
    }
}
