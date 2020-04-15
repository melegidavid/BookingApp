package proj.xmlws.UserModule.service;

import proj.xmlws.UserModule.dto.UserDTO;


public interface MailService {

    void sendNotification(UserDTO userDTO);
}
