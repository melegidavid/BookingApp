package proj.xmlws.service;

import proj.xmlws.dto.AccommodationDTO;
import proj.xmlws.dto.AccommodationListDTO;
import proj.xmlws.dto.AccommodationSearchDTO;

public interface AccommodationService {

    AccommodationListDTO findAllAccommodations();

    AccommodationDTO findAccommodation(Long id);

    boolean saveAccommodation(AccommodationDTO accommodationDTO);

    boolean updateAccommodation(AccommodationDTO accommodationDTO);

    boolean removeAccommodation(Long id);

    boolean addAccommodationService(Long accommodationId, Long serviceId);

    boolean removeAccommodationService(Long accommodationId, Long serviceId);

    AccommodationListDTO getAccommodationWithFreeUnits(AccommodationSearchDTO accommodationSearchDTO);
}
