package proj.xmlws.service;

import proj.xmlws.dto.AccommodationUnitTypeDTO;
import proj.xmlws.dto.AccommodationUnitTypeListDTO;

public interface AccommodationUnitTypeService {

    AccommodationUnitTypeListDTO getAllAccommodationUnitTypes();

    AccommodationUnitTypeDTO findAccommodationUnitType(Long accommodationUnitTypeId);

    boolean saveAccommodationUnitType(AccommodationUnitTypeDTO accommodationUnitTypeDTO);

    boolean updateAccommodationUnitType(Long accommodationUnitTypeId,AccommodationUnitTypeDTO accommodationUnitTypeDTO);

    boolean removeAccommodationUnitType(Long accommodationUnitTypeId);
}
