package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.MessageDTO;
import proj.xmlws.MessageModule.model.reservation.Message;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ReservationMapper.class,
                                            AccommodationMapper.class})
public interface MessageMapper {

    Message map(MessageDTO messageDTO);

    MessageDTO map(Message message);
}
