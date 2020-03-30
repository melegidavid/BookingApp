package proj.xmlws.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.dto.AccommodationUnitTypeDTO;
import proj.xmlws.dto.AccommodationUnitTypeListDTO;
import proj.xmlws.exception.AccommodationException;
import proj.xmlws.mapper.AccommodationUnitTypeMapper;
import proj.xmlws.model.accommodation.AccommodationUnitType;
import proj.xmlws.repository.AccommodationUnitTypeRepository;
import proj.xmlws.service.AccommodationUnitTypeService;

import java.util.List;

@Service
public class AccommodationUnitTypeServiceImpl implements AccommodationUnitTypeService {

    @Autowired
    private AccommodationUnitTypeRepository accommodationUnitTypeRepository;

    @Autowired
    private AccommodationUnitTypeMapper accommodationUnitTypeMapper;

    @Override
    public AccommodationUnitTypeListDTO getAllAccommodationUnitTypes() {
        List<AccommodationUnitType> accommodationUnitTypeList = accommodationUnitTypeRepository.getAllAccommodationUnitTypes();
        AccommodationUnitTypeListDTO accommodationUnitTypeListDTO = new AccommodationUnitTypeListDTO();
        if(!accommodationUnitTypeList.isEmpty()) {
            for(AccommodationUnitType aut : accommodationUnitTypeList) {
                accommodationUnitTypeListDTO.getAccommodationUnitTypeDTOList().add(accommodationUnitTypeMapper.map(aut));
            }
        } else {
            return new AccommodationUnitTypeListDTO();
        }
        return accommodationUnitTypeListDTO;
    }

    @Override
    public AccommodationUnitTypeDTO findAccommodationUnitType(Long accommodationUnitTypeId) {
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeRepository.getOne(accommodationUnitTypeId);
        if(!accommodationUnitType.isDeleted() && accommodationUnitType != null){
            return accommodationUnitTypeMapper.map(accommodationUnitType);
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit type doesn't exist");
        }
    }

    @Override
    public boolean saveAccommodationUnitType(AccommodationUnitTypeDTO accommodationUnitTypeDTO) {
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeMapper.map(accommodationUnitTypeDTO);
        accommodationUnitTypeRepository.save(accommodationUnitType);
        return true;
    }

    @Override
    public boolean updateAccommodationUnitType(Long accommodationUnitTypeId, AccommodationUnitTypeDTO accommodationUnitTypeDTO) {
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeRepository.getOne(accommodationUnitTypeId);
        if(accommodationUnitType.isDeleted() || accommodationUnitType == null) {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit type doesn't exist");
        } else {
            accommodationUnitType = accommodationUnitTypeMapper.map(accommodationUnitTypeDTO);
            accommodationUnitTypeRepository.save(accommodationUnitType);
            return true;
        }
    }

    @Override
    public boolean removeAccommodationUnitType(Long accommodationUnitTypeId) {
        AccommodationUnitType accommodationUnitType = accommodationUnitTypeRepository.getOne(accommodationUnitTypeId);
        if(accommodationUnitType == null) {
            throw  new AccommodationException(HttpStatus.NOT_FOUND, "Accommodation unit type doesn't exist");
        } else {
            accommodationUnitType.setDeleted(true);
            accommodationUnitTypeRepository.save(accommodationUnitType);
            return true;
        }
    }
}
