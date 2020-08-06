package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.ReservationDTO;
import proj.xmlws.MessageModule.model.reservation.Reservation;

@Mapper(componentModel = "spring", uses = {AccommodationUnitMapper.class, CommentRateMapper.class})
public interface ReservationMapper {

    Reservation map(ReservationDTO reservationDTO);

    ReservationDTO map(Reservation reservation);
}
