package proj.xmlws.dto;

import java.util.ArrayList;
import java.util.List;

public class AccommodationUnitListDTO {

    List<AccommodationUnitDTO> accommodationUnitDTOList;

    public AccommodationUnitListDTO() {
        this.accommodationUnitDTOList = new ArrayList<>();
    }

    public List<AccommodationUnitDTO> getAccommodationUnitDTOList() {
        return accommodationUnitDTOList;
    }

    public void setAccommodationUnitDTOList(List<AccommodationUnitDTO> accommodationUnitDTOList) {
        this.accommodationUnitDTOList = accommodationUnitDTOList;
    }
}
