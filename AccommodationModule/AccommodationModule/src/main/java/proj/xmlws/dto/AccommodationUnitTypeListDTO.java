package proj.xmlws.dto;

import java.util.ArrayList;
import java.util.List;

public class AccommodationUnitTypeListDTO {

    private List<AccommodationUnitTypeDTO> accommodationUnitTypeDTOList;

    public AccommodationUnitTypeListDTO() {
        this.accommodationUnitTypeDTOList = new ArrayList<>();
    }

    public List<AccommodationUnitTypeDTO> getAccommodationUnitTypeDTOList() {
        return accommodationUnitTypeDTOList;
    }

    public void setAccommodationUnitTypeDTOList(List<AccommodationUnitTypeDTO> accommodationUnitTypeDTOList) {
        this.accommodationUnitTypeDTOList = accommodationUnitTypeDTOList;
    }
}
