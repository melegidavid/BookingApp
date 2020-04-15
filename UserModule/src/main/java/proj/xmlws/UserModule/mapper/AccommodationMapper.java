package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.AccommodationDTO;
import proj.xmlws.UserModule.model.accommodation.Accommodation;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {

    Accommodation map(AccommodationDTO accommodationDTO);

    AccommodationDTO map(Accommodation accommodation);
}
