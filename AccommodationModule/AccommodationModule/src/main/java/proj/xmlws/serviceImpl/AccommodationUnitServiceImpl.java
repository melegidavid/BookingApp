package proj.xmlws.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.dto.AccommodationUnitDTO;
import proj.xmlws.dto.AccommodationUnitListDTO;
import proj.xmlws.exception.AccommodationException;
import proj.xmlws.mapper.AccommodationMapper;
import proj.xmlws.mapper.AccommodationUnitMapper;
import proj.xmlws.model.accommodation.Accommodation;
import proj.xmlws.model.accommodation.AccommodationUnit;
import proj.xmlws.model.accommodation.AccommodationUnitType;
import proj.xmlws.repository.AccommodationRepository;
import proj.xmlws.repository.AccommodationUnitRepository;
import proj.xmlws.repository.AccommodationUnitTypeRepository;
import proj.xmlws.service.AccommodationUnitService;
import java.util.List;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

    @Autowired
    AccommodationUnitMapper accommodationUnitMapper;

    @Autowired
    AccommodationMapper accommodationMapper;

    @Autowired
    private AccommodationUnitRepository accommodationUnitRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AccommodationUnitTypeRepository accommodationUnitTypeRepository;

    @Override
    public AccommodationUnitListDTO getAllAccommodationUnits() {
        AccommodationUnitListDTO accommodationUnitListDTO = new AccommodationUnitListDTO();
        List<AccommodationUnit> accommodationUnitList = accommodationUnitRepository.getAllAccommodationUnits();
        if(accommodationUnitList.isEmpty()) {
            return new AccommodationUnitListDTO();
        } else {
            for(AccommodationUnit au: accommodationUnitList) {
                accommodationUnitListDTO.getAccommodationUnitDTOList().add(accommodationUnitMapper.map(au));
            }
        }
        return accommodationUnitListDTO;
    }

    @Override
    public AccommodationUnitDTO findAccommodationUnit(Long accommodationUnitId) {
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(accommodationUnitId);
        if(accommodationUnit.isDeleted() || accommodationUnit == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit doesn't exist");
        } else {
            return accommodationUnitMapper.map(accommodationUnit);
        }
    }

    @Override
    public boolean saveAccommodationUnit(AccommodationUnitDTO accommodationUnitDTO, Long accommodationId) {
        Accommodation accommodation = accommodationRepository.getOne(accommodationId);
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeRepository.getOne(accommodationUnitDTO.getAccommodationUnitType().getId());
        AccommodationUnit accommodationUnit = accommodationUnitMapper.map(accommodationUnitDTO);
        accommodationUnit.setAccommodation(accommodation);
        accommodationUnit.setAccommodationUnitType(accommodationUnitType);
        accommodationUnitRepository.save(accommodationUnit);
        return true;
    }

    @Override
    public boolean updateAccommodationUnit(Long accommodationUnitId, AccommodationUnitDTO accommodationUnitDTO) {
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(accommodationUnitId);
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeRepository.getOne(accommodationUnitDTO.getAccommodationUnitType().getId());
        Accommodation accommodation = accommodationRepository.getOne(accommodationUnitDTO.getAccommodation().getId());
        if(!accommodationUnit.isDeleted() && accommodationUnit != null) {
            accommodationUnit = accommodationUnitMapper.map(accommodationUnitDTO);
            accommodationUnit.setAccommodationUnitType(accommodationUnitType);
            accommodationUnit.setAccommodation(accommodation);
            accommodationUnitRepository.save(accommodationUnit);
            return  true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit doesn't exist");
        }
    }

    @Override
    public boolean removeAccommodationUnit(Long accommodationUnitId) {
        AccommodationUnit accommodationUnit = accommodationUnitRepository.getOne(accommodationUnitId);
        if(accommodationUnit != null) {
            accommodationUnit.setDeleted(true);
            accommodationUnitRepository.save(accommodationUnit);
            return true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit doesn't exist");
        }
    }

    @Override
    public AccommodationUnitListDTO getAllUnitsOfAccommodation(Long accommodationId) {
        List<AccommodationUnit> accommodationUnitList = accommodationUnitRepository.getAllUnitsOfAccommodation(accommodationId);
        AccommodationUnitListDTO accommodationUnitListDTO = new AccommodationUnitListDTO();
        if(!accommodationUnitList.isEmpty()) {
            for(AccommodationUnit au : accommodationUnitList) {
                accommodationUnitListDTO.getAccommodationUnitDTOList().add(accommodationUnitMapper.map(au));
            }
            return accommodationUnitListDTO;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "There is no rooms!");
        }
    }
}
