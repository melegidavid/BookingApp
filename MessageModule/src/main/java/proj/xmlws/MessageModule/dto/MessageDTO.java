package proj.xmlws.MessageModule.dto;

import java.time.LocalDateTime;

public class MessageDTO {

    private Long id;
    private String messageContent;
    private boolean seen;
    private UserDTO sender;
    private UserDTO reciever;
    private ReservationDTO reservation;
    private  AccommodationDTO accommodation;
    private LocalDateTime dateTime;

    public MessageDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public UserDTO getReciever() {
        return reciever;
    }

    public void setReciever(UserDTO reciever) {
        this.reciever = reciever;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

    public AccommodationDTO getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationDTO accommodation) {
        this.accommodation = accommodation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
