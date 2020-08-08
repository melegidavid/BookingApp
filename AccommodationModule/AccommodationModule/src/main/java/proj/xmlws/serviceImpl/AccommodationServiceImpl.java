package proj.xmlws.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.dto.*;
import proj.xmlws.exception.AccommodationException;
import proj.xmlws.mapper.AccommodationMapper;
import proj.xmlws.model.accommodation.Accommodation;
import proj.xmlws.repository.AccommodationRepository;
import proj.xmlws.repository.AccommodationUnitRepository;
import proj.xmlws.repository.ServiceRepository;
import proj.xmlws.service.AccommodationService;
import proj.xmlws.service.AccommodationUnitService;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    private AccommodationMapper accommodationMapper;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Override
    public AccommodationListDTO findAllAccommodations() {
        AccommodationListDTO accommodationsDTO = new AccommodationListDTO();
        List<Accommodation> accommodationList = accommodationRepository.findAllAccommodations();
        if (accommodationList.isEmpty()) {
            return new AccommodationListDTO();
        } else {
            for (Accommodation a : accommodationList) {
                accommodationsDTO.getAccommodationList().add(accommodationMapper.map(a));
            }
        }
        return accommodationsDTO;
    }

    @Override
    public AccommodationDTO findAccommodation(Long id) {
        Accommodation accommodation = accommodationRepository.getOne(id);
        if(accommodation.isDeleted() || accommodation == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND ,"Accommodation not found");
        } else {
            return accommodationMapper.map(accommodation);
        }
    }

    @Override
    public boolean saveAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = accommodationMapper.map(accommodationDTO);
        accommodationRepository.save(accommodation);
        return true;
    }

    @Override
    public boolean updateAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = accommodationRepository.getOne(accommodationDTO.getId());
        if(!accommodation.isDeleted() && accommodation != null) {
            accommodation = accommodationMapper.map(accommodationDTO);
            accommodationRepository.save(accommodation);
            return true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation not found");
        }

    }

    @Override
    public boolean removeAccommodation(Long id) {
        Accommodation accommodation = accommodationRepository.getOne(id);
        if(accommodation != null) {
            accommodation.setDeleted(true);
            accommodationRepository.save(accommodation);
            return true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation doesn't exist");
        }
    }


    public AccommodationListDTO getAccommodationWithFreeUnits(AccommodationSearchDTO accommodationSearchDTO) {
        AccommodationListDTO accommodationListDTO = this.findAllAccommodations();
        AccommodationListDTO freeAccommodationListDTO = new AccommodationListDTO();
        for(AccommodationDTO aDTO : accommodationListDTO.getAccommodationList()) {
            Accommodation accommodation = accommodationRepository.getOne(aDTO.getId());
            AccommodationUnitListDTO freeAccommodationUnits = accommodationUnitService.getFreeAccommodationUnits(accommodationSearchDTO, aDTO.getId());
            if(!freeAccommodationUnits.getAccommodationUnitDTOList().isEmpty()) {
                int numberOfBeds = 0;
                for(AccommodationUnitDTO auDTO : freeAccommodationUnits.getAccommodationUnitDTOList()) {
                    numberOfBeds += auDTO.getNumberOfBeds();
                }
                if(numberOfBeds > accommodationSearchDTO.getNumberOfGuests()) {
                    if (accommodationSearchDTO.getAccommodationTypes().contains(aDTO.getAccommodationType()) || (accommodationSearchDTO.getAccommodationTypes().isEmpty())) {
                        int numberOfServices = 0;
                        for(ServiceDTO sDTO : accommodationSearchDTO.getServices()) {
                            for(proj.xmlws.model.accommodation.Service s : accommodation.getServices()) {
                                if(sDTO.getName().equals(s.getName())) {
                                    numberOfServices++;
                                }
                            }
                        }
                        if(numberOfServices >= accommodationSearchDTO.getServices().size())
                            freeAccommodationListDTO.getAccommodationList().add(aDTO);
                    }
                }
            }
        }
        return freeAccommodationListDTO;
    }

//    ******************************************************************************************
//                        ACCOMMODATION SERVICES
//    ******************************************************************************************

    @Override
    public boolean addAccommodationService(Long accommodationId, Long serviceId) {
        Accommodation accommodation = accommodationRepository.getOne(accommodationId);
        proj.xmlws.model.accommodation.Service service = serviceRepository.getOne(serviceId);
        if(accommodation.isDeleted() || accommodation == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation doesn't exist");
        } else if(service.isDeleted() || service == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Service doesn't exist");
        } else if(accommodation.getServices().contains(service)) {
            throw new AccommodationException(HttpStatus.BAD_REQUEST, "Accommodation already has that service");
        } else {
            accommodation.getServices().add(service);
            accommodationMapper.map(accommodationRepository.save(accommodation));
            return true;
        }
    }

    @Override
    public boolean removeAccommodationService(Long accommodationId, Long serviceId) {
        Accommodation accommodation = accommodationRepository.getOne(accommodationId);
        proj.xmlws.model.accommodation.Service service = serviceRepository.getOne(serviceId);
        if(accommodation.isDeleted() || accommodation == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation doesn't exist");
        } else if(service.isDeleted() || service == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Service doesn't exist");
        } else {
            Predicate<proj.xmlws.model.accommodation.Service> predicate = p -> p.getId() == serviceId;
            accommodation.getServices().removeIf(predicate);
            accommodationRepository.save(accommodation);
            return true;
        }
    }
}
