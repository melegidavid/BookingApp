package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.AccommodationUnitTypeDTO;
import proj.xmlws.MessageModule.model.accommodation.AccommodationUnitType;

@Mapper(componentModel = "spring")
public interface AccommodationUnitTypeMapper {

    AccommodationUnitType map(AccommodationUnitTypeDTO accommodationUnitTypeDTO);

    AccommodationUnitTypeDTO map(AccommodationUnitType accommodationUnitType);
}
