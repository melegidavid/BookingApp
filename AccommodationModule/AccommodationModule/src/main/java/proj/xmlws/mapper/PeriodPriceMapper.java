package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.PeriodPriceDTO;
import proj.xmlws.model.accommodation.PeriodPrice;

@Mapper(componentModel = "spring", uses = {AccommodationUnitMapper.class})
public interface PeriodPriceMapper {

    PeriodPrice map(PeriodPriceDTO periodPriceDTO);

    PeriodPriceDTO map(PeriodPrice periodPrice);
}
