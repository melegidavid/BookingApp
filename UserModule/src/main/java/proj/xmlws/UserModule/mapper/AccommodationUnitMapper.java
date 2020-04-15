package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.AccommodationUnitDTO;
import proj.xmlws.UserModule.model.accommodation.AccommodationUnit;

@Mapper(componentModel = "spring", uses = {AccommodationMapper.class, AccommodationUnitTypeMapper.class})
public interface AccommodationUnitMapper {

    AccommodationUnit map(AccommodationUnitDTO accommodationUnitDTO);

    AccommodationUnitDTO map(AccommodationUnit accommodationUnit);
}
