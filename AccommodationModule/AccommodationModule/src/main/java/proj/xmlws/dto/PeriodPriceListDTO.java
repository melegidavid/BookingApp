package proj.xmlws.dto;

import java.util.ArrayList;
import java.util.List;

public class PeriodPriceListDTO {

    private List<PeriodPriceDTO> periodPriceDTOList;

    public PeriodPriceListDTO() {
        this.periodPriceDTOList = new ArrayList<>();
    }

    public List<PeriodPriceDTO> getPeriodPriceDTOList() {
        return periodPriceDTOList;
    }

    public void setPeriodPriceDTOList(List<PeriodPriceDTO> periodPriceDTOList) {
        this.periodPriceDTOList = periodPriceDTOList;
    }
}
