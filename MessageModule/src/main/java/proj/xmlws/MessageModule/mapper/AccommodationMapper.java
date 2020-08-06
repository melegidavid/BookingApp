package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.AccommodationDTO;
import proj.xmlws.MessageModule.model.accommodation.Accommodation;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {

    Accommodation map(AccommodationDTO accommodationDTO);

    AccommodationDTO map(Accommodation accommodation);
}
