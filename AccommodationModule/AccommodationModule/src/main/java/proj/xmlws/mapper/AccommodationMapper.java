package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.AccommodationDTO;
import proj.xmlws.model.accommodation.Accommodation;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface AccommodationMapper {

    AccommodationDTO map(Accommodation accommodation);

    Accommodation map(AccommodationDTO accommodationDTO);

}
