package proj.xmlws.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.dto.AddressDTO;
import proj.xmlws.model.users.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO map(Address address);

    Address map(AddressDTO addressDTO);

}
