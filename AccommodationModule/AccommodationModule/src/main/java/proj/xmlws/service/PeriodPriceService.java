package proj.xmlws.service;

import proj.xmlws.dto.PeriodPriceDTO;
import proj.xmlws.dto.PeriodPriceDatesDTO;
import proj.xmlws.dto.PeriodPriceListDTO;

public interface PeriodPriceService {

    PeriodPriceListDTO getAllPeriodPrices(Long accommodationUnitId);

    PeriodPriceDTO findPeriodPrice(Long periodPriceId);

    boolean savePeriodPrice(Long accommodationUnitId, PeriodPriceDTO periodPriceDTO);

    boolean updatePeriodPrice(Long periodPriceId, PeriodPriceDTO periodPriceDTO);

    boolean removePeriodPrice(Long periodPriceId);

    double getPeriodPriceForMonth(Long accommodationUnitId, PeriodPriceDatesDTO periodPriceDatesDTO);

}
