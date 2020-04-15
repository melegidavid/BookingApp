package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.ReservationDTO;
import proj.xmlws.UserModule.model.reservation.Reservation;

@Mapper(componentModel = "spring", uses = {AccommodationUnitMapper.class, CommentRateMapper.class})
public interface ReservationMapper {

    Reservation map(ReservationDTO reservationDTO);

    ReservationDTO map(Reservation reservation);
}
