package proj.xmlws.dto;

import java.util.ArrayList;
import java.util.List;

public class AccommodationListDTO {

    List<AccommodationDTO> accommodationList;

    public AccommodationListDTO() {
        this.accommodationList = new ArrayList<>();
    }

    public List<AccommodationDTO> getAccommodationList() {
        return accommodationList;
    }

    public void setAccommodationList(List<AccommodationDTO> accommodationList) {
        this.accommodationList = accommodationList;
    }



}
