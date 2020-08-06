package proj.xmlws.MessageModule.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.MessageModule.dto.MessageDTO;
import proj.xmlws.MessageModule.dto.MessageListDTO;
import proj.xmlws.MessageModule.exception.MessageException;
import proj.xmlws.MessageModule.mapper.MessageMapper;
import proj.xmlws.MessageModule.model.reservation.Message;
import proj.xmlws.MessageModule.model.users.User;
import proj.xmlws.MessageModule.repository.AccommodationRepository;
import proj.xmlws.MessageModule.repository.MessageRepository;
import proj.xmlws.MessageModule.repository.ReservationRepository;
import proj.xmlws.MessageModule.repository.UserRepository;
import proj.xmlws.MessageModule.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public MessageDTO getMessage(Long messageId) {
        Message message = messageRepository.findMessage(messageId);
        if(message == null)
            throw new MessageException(HttpStatus.NOT_FOUND, "Message doesn't exist");
        return messageMapper.map(message);
    }

    @Override
    public MessageListDTO getMessagesByReservation(Long reservationId) {
        List<Message> messageList = messageRepository.getAllMessagesOfReservation(reservationId);
        MessageListDTO messageListDTO = new MessageListDTO();
        if(!messageList.isEmpty()) {
            for(Message m : messageList)
                messageListDTO.getMessageDTOList().add(messageMapper.map(m));
            return messageListDTO;
        }
        return messageListDTO;
    }

    @Override
    public boolean sendMessage(MessageDTO messageDTO) {
        Message message = messageMapper.map(messageDTO);
        message.setSender(userRepository.findByUsername(messageDTO.getSender().getUsername()));
        message.setReservation(reservationRepository.findReservation(messageDTO.getReservation().getId()));
        message.setAccommodation(accommodationRepository.findAccommodation(messageDTO.getAccommodation().getId()));
        messageRepository.save(message);
        return true;
    }

    @Override
    public boolean respondToMessage(Long respondMessageId, MessageDTO messageDTO) {
        Message message = messageRepository.findMessage(respondMessageId);
        User agent = userRepository.findByUsername(messageDTO.getSender().getUsername());
        if(message == null)
            throw new MessageException(HttpStatus.NOT_FOUND, "Message doesn't exist");

        message.setReciever(agent);
        message.setSeen(true);
        message.setAccommodation(null);
        messageRepository.save(message);

        message.setSeen(false);
        Message message1 = messageMapper.map(messageDTO);
        message1.setSender(agent);
        message1.setReciever(message.getSender());
        message1.setReservation(reservationRepository.findReservation(messageDTO.getReservation().getId()));
        message1.setAccommodation(null);
        messageRepository.save(message1);

        return true;
    }

    @Override
    public boolean removeMessage(Long messageId) {
        Message message = messageRepository.findMessage(messageId);
        if(message == null)
            throw new MessageException(HttpStatus.NOT_FOUND, "Message doesn't exist");
        else {
            message.setDeleted(true);
            messageRepository.save(message);
            return true;
        }
    }
}
