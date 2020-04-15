package proj.xmlws.UserModule.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.xmlws.UserModule.mapper.MessageMapper;
import proj.xmlws.UserModule.repository.MessageRepository;

@Service
public class MessageServiceImpl {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;



}
