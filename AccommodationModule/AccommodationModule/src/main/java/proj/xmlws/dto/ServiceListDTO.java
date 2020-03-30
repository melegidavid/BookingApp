package proj.xmlws.dto;

import java.util.ArrayList;
import java.util.List;

public class ServiceListDTO {

    List<ServiceDTO> serviceDTOList;

    public ServiceListDTO() {
        this.serviceDTOList = new ArrayList<>();
    }

    public List<ServiceDTO> getServiceDTOList() {
        return serviceDTOList;
    }

    public void setServiceDTOList(List<ServiceDTO> serviceDTOList) {
        this.serviceDTOList = serviceDTOList;
    }
}
