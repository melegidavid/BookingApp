package proj.xmlws.MessageModule.dto;

public class AccommodationUnitDTO {

    private int floor;
    private String number;
    private int numberOfBeds;
    private double defaultPrice;
    private AccommodationUnitTypeDTO accommodationUnitType;
    private Long id;
    private AccommodationDTO accommodation;

    public AccommodationUnitDTO() {

    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public AccommodationUnitTypeDTO getAccommodationUnitType() {
        return accommodationUnitType;
    }

    public void setAccommodationUnitType(AccommodationUnitTypeDTO accommodationUnitType) {
        this.accommodationUnitType = accommodationUnitType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccommodationDTO getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationDTO accommodation) {
        this.accommodation = accommodation;
    }

}
