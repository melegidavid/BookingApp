package proj.xmlws.MessageModule.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private Long id;
    private boolean confirmed;
    private UserDTO guest;
    private AccommodationUnitDTO accommodationUnit;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private boolean agentConfirmed;
    private CommentRateDTO commentRate;
    private double price;

    public ReservationDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public UserDTO getGuest() {
        return guest;
    }

    public void setGuest(UserDTO guest) {
        this.guest = guest;
    }

    public AccommodationUnitDTO getAccommodationUnit() {
        return accommodationUnit;
    }

    public void setAccommodationUnit(AccommodationUnitDTO accommodationUnit) {
        this.accommodationUnit = accommodationUnit;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public boolean isAgentConfirmed() {
        return agentConfirmed;
    }

    public void setAgentConfirmed(boolean agentConfirmed) {
        this.agentConfirmed = agentConfirmed;
    }

    public CommentRateDTO getComment() {
        return commentRate;
    }

    public void setComment(CommentRateDTO comment) {
        this.commentRate = comment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
