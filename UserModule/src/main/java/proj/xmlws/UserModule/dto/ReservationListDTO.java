package proj.xmlws.UserModule.dto;

import java.util.ArrayList;
import java.util.List;

public class ReservationListDTO {

    private List<ReservationDTO> reservationDTOList;

    public ReservationListDTO() {
        this.reservationDTOList = new ArrayList<>();
    }

    public List<ReservationDTO> getReservationDTOList() {
        return reservationDTOList;
    }

    public void setReservationDTOList(List<ReservationDTO> reservationDTOList) {
        this.reservationDTOList = reservationDTOList;
    }
}
