package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.AddressDTO;
import proj.xmlws.UserModule.model.users.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address map(AddressDTO addressDTO);

    AddressDTO map(Address address);
}
