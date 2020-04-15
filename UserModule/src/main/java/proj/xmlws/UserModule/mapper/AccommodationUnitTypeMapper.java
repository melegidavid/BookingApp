package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.AccommodationUnitTypeDTO;
import proj.xmlws.UserModule.model.accommodation.AccommodationUnitType;

@Mapper(componentModel = "spring")
public interface AccommodationUnitTypeMapper {

    AccommodationUnitType map(AccommodationUnitTypeDTO accommodationUnitTypeDTO);

    AccommodationUnitTypeDTO map(AccommodationUnitType accommodationUnitType);
}
