package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.ServiceDTO;
import proj.xmlws.model.accommodation.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Service map(ServiceDTO serviceDTO);

    ServiceDTO map(Service service);
}
