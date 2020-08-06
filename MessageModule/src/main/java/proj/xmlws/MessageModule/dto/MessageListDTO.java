package proj.xmlws.MessageModule.dto;

import java.util.List;

public class MessageListDTO {

    private List<MessageDTO> messageDTOList;

    public MessageListDTO() {

    }

    public List<MessageDTO> getMessageDTOList() {
        return messageDTOList;
    }

    public void setMessageDTOList(List<MessageDTO> messageDTOList) {
        this.messageDTOList = messageDTOList;
    }
}
