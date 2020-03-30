package proj.xmlws.dto;

import java.time.LocalDate;


public class PeriodPriceDTO {

    private LocalDate fromDate;
    private LocalDate toDate;
    private double price;
    private Long id;
    private AccommodationUnitDTO accommodationUnit;

    public PeriodPriceDTO() {

    }


    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccommodationUnitDTO getAccommodationUnit() {
        return accommodationUnit;
    }

    public void setAccommodationUnit(AccommodationUnitDTO accommodationUnit) {
        this.accommodationUnit = accommodationUnit;
    }
}
