package proj.xmlws.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import proj.xmlws.dto.ServiceDTO;
import proj.xmlws.dto.ServiceListDTO;
import proj.xmlws.exception.AccommodationException;
import proj.xmlws.mapper.ServiceMapper;
import proj.xmlws.model.accommodation.Service;
import proj.xmlws.repository.ServiceRepository;
import proj.xmlws.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public ServiceListDTO getAllServices() {
        List<Service> serviceList = serviceRepository.getAllServices();
        ServiceListDTO serviceListDTO = new ServiceListDTO();
        if(!serviceList.isEmpty()) {
            for(Service s : serviceList) {
                serviceListDTO.getServiceDTOList().add(serviceMapper.map(s));
            }
        }
        return serviceListDTO;
    }

    @Override
    public ServiceDTO findService(Long serviceId) {
        Service service = serviceRepository.getOne(serviceId);
        if(!service.isDeleted() && service != null) {
            return serviceMapper.map(service);
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Service doesn't exist");
        }
    }

    @Override
    public boolean saveService(ServiceDTO serviceDTO) {
        Service service = serviceMapper.map(serviceDTO);
        serviceRepository.save(service);
        return true;
    }

    @Override
    public  boolean updateService(Long serviceId, ServiceDTO serviceDTO) {
        Service service = serviceRepository.getOne(serviceId);
        if(!service.isDeleted() && service != null) {
            service = serviceMapper.map(serviceDTO);
            serviceRepository.save(service);
            return true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Service doesn't exist");
        }
    }

    @Override
    public boolean removeService(Long serviceId) {
        Service service = serviceRepository.getOne(serviceId);
        if(service != null) {
            service.setDeleted(true);
            serviceRepository.save(service);
            return true;
        } else {
            throw new AccommodationException(HttpStatus.NOT_FOUND, "Service doesn't exist");
        }
    }

    @Override
    public ServiceListDTO getAccommodationServices(Long accommodationId) {
        List<Service> serviceList = serviceRepository.getAccommodationServices(accommodationId);
        ServiceListDTO serviceListDTO = new ServiceListDTO();
        if(!serviceList.isEmpty()) {
            for(Service s: serviceList) {
                serviceListDTO.getServiceDTOList().add(serviceMapper.map(s));
            }
        }
        return serviceListDTO;
    }
}
