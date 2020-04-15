package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.MessageDTO;
import proj.xmlws.UserModule.model.reservation.Message;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ReservationMapper.class,
                                            AccommodationMapper.class})
public interface MessageMapper {

    Message map(MessageDTO messageDTO);

    MessageDTO map(Message message);
}
