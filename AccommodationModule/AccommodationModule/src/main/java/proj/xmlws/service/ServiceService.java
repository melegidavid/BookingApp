package proj.xmlws.service;

import proj.xmlws.dto.ServiceDTO;
import proj.xmlws.dto.ServiceListDTO;

public interface ServiceService {

    ServiceListDTO getAllServices();

    ServiceDTO findService(Long serviceId);

    boolean saveService(ServiceDTO serviceDTO);

    boolean updateService(Long serviceId, ServiceDTO serviceDTO);

    boolean removeService(Long serviceId);

    ServiceListDTO getAccommodationServices(Long accommodationId);
}
