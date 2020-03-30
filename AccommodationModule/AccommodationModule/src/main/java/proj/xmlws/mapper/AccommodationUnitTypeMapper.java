package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.AccommodationUnitTypeDTO;
import proj.xmlws.model.accommodation.AccommodationUnitType;

@Mapper(componentModel = "spring")
public interface AccommodationUnitTypeMapper {

    AccommodationUnitTypeDTO map(AccommodationUnitType accommodationUnitType);

    AccommodationUnitType map(AccommodationUnitTypeDTO accommodationUnitTypeDTO);

}
