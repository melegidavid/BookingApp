package proj.xmlws.dto;

import java.time.LocalDate;

public class PeriodPriceDatesDTO {

    private LocalDate fromDate;
    private LocalDate toDate;

    public PeriodPriceDatesDTO() {

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
}
