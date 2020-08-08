package proj.xmlws.service;

import proj.xmlws.dto.AccommodationListDTO;
import proj.xmlws.dto.AccommodationSearchDTO;
import proj.xmlws.dto.AccommodationUnitDTO;
import proj.xmlws.dto.AccommodationUnitListDTO;

import java.time.LocalDate;

public interface AccommodationUnitService {

    AccommodationUnitListDTO getAllAccommodationUnits();

    AccommodationUnitDTO findAccommodationUnit(Long accommodationUnitId);

    boolean saveAccommodationUnit(AccommodationUnitDTO accommodationUnitDTO, Long accommodationId);

    boolean updateAccommodationUnit(Long accommodationUnitId, AccommodationUnitDTO accommodationUnitDTO);

    boolean removeAccommodationUnit(Long accommodationUnitId);

    AccommodationUnitListDTO getAllUnitsOfAccommodation(Long accommodationId);

    AccommodationUnitListDTO getFreeAccommodationUnits(AccommodationSearchDTO accommodationSearchDTO, Long accommodationId);
}
