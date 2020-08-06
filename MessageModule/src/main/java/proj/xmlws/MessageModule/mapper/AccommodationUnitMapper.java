package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.AccommodationUnitDTO;
import proj.xmlws.MessageModule.model.accommodation.AccommodationUnit;

@Mapper(componentModel = "spring", uses = {AccommodationMapper.class, AccommodationUnitTypeMapper.class})
public interface AccommodationUnitMapper {

    AccommodationUnit map(AccommodationUnitDTO accommodationUnitDTO);

    AccommodationUnitDTO map(AccommodationUnit accommodationUnit);
}
