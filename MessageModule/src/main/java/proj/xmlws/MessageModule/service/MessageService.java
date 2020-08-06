package proj.xmlws.MessageModule.service;

import proj.xmlws.MessageModule.dto.MessageDTO;
import proj.xmlws.MessageModule.dto.MessageListDTO;

public interface MessageService {

    MessageDTO getMessage(Long messageId);

    MessageListDTO getMessagesByReservation(Long reservationId);

    boolean sendMessage(MessageDTO messageDTO);

    boolean respondToMessage(Long respondMessageId, MessageDTO messageDTO);

    boolean removeMessage(Long messageId);
}
