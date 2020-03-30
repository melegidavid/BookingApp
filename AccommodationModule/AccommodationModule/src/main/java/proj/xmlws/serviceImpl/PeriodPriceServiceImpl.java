package proj.xmlws.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.dto.PeriodPriceDTO;
import proj.xmlws.dto.PeriodPriceDatesDTO;
import proj.xmlws.dto.PeriodPriceListDTO;
import proj.xmlws.exception.AccommodationException;
import proj.xmlws.mapper.PeriodPriceMapper;
import proj.xmlws.model.accommodation.AccommodationUnit;
import proj.xmlws.model.accommodation.PeriodPrice;
import proj.xmlws.repository.AccommodationUnitRepository;
import proj.xmlws.repository.PeriodPriceRepository;
import proj.xmlws.service.PeriodPriceService;

import java.util.List;

@Service
public class PeriodPriceServiceImpl implements PeriodPriceService {

    @Autowired
    private PeriodPriceRepository periodPriceRepository;

    @Autowired
    private PeriodPriceMapper periodPriceMapper;

    @Autowired
    private AccommodationUnitRepository accommodationUnitRepository;

    @Override
    public PeriodPriceListDTO getAllPeriodPrices(Long accommodationUnitId) {
        List<PeriodPrice> periodPriceList = periodPriceRepository.getAllPeriodPrices(accommodationUnitId);
        PeriodPriceListDTO periodPriceListDTO = new PeriodPriceListDTO();
        if(!periodPriceList.isEmpty()) {
            for(PeriodPrice pp : periodPriceList) {
                periodPriceListDTO.getPeriodPriceDTOList().add(periodPriceMapper.map(pp));
            }
        }
        return periodPriceListDTO;
    }

    @Override
    public PeriodPriceDTO findPeriodPrice(Long periodPriceId) {
        PeriodPrice periodPrice = periodPriceRepository.getOne(periodPriceId);
        if(!periodPrice.isDeleted() && periodPrice != null) {
            return periodPriceMapper.map(periodPrice);
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Period price doesn't exist");
        }
    }

    @Override
    public boolean savePeriodPrice(Long accommodatoinUnitId, PeriodPriceDTO periodPriceDTO) {
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(accommodatoinUnitId);
        if(accommodationUnit.isDeleted() || accommodationUnit == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit not found");
        } else {
            PeriodPrice periodPrice = new PeriodPrice();
            periodPrice = periodPriceMapper.map(periodPriceDTO);
            periodPrice.setAccommodationUnit(accommodationUnit);
            periodPriceRepository.save(periodPrice);
            return true;
        }
    }

    @Override
    public boolean updatePeriodPrice(Long periodPriceId, PeriodPriceDTO periodPriceDTO) {
        PeriodPrice periodPrice = periodPriceRepository.getOne(periodPriceId);
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(periodPriceDTO.getAccommodationUnit().getId());
        if(periodPrice.isDeleted() || periodPrice == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Period price doesn't exist");
        } else {
            periodPrice = periodPriceMapper.map(periodPriceDTO);
            periodPrice.setAccommodationUnit(accommodationUnit);
            periodPriceRepository.save(periodPrice);
            return true;
        }
    }

    @Override
    public boolean removePeriodPrice(Long periodPriceId) {
        PeriodPrice periodPrice = periodPriceRepository.getOne(periodPriceId);
        if(periodPrice.isDeleted() || periodPrice == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Period price doesn't exist");
        } else {
            periodPrice.setDeleted(true);
            periodPriceRepository.save(periodPrice);
            return true;
        }
    }

    @Override
    public double getPeriodPriceForMonth(Long accommodationUnitId, PeriodPriceDatesDTO periodPriceDatesDTO) {
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(accommodationUnitId);
        if(accommodationUnit.isDeleted() || accommodationUnit == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit doesn't exist");
        } else {
            PeriodPrice periodPrice = periodPriceRepository.getPeriodPriceForMonth(accommodationUnitId, periodPriceDatesDTO.getFromDate());
            if(periodPrice == null) {
                return accommodationUnit.getDefaultPrice();
            } else {
                return periodPrice.getPrice();
            }
        }
    }


}
