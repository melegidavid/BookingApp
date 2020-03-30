package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.AccommodationUnitDTO;
import proj.xmlws.model.accommodation.AccommodationUnit;

@Mapper(componentModel = "spring", uses = {AccommodationUnitTypeMapper.class, AccommodationMapper.class})
public interface AccommodationUnitMapper {

    AccommodationUnit map(AccommodationUnitDTO accommodationUnitDTO);

    AccommodationUnitDTO map(AccommodationUnit accommodationUnit);

}
