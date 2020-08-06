package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.AddressDTO;
import proj.xmlws.MessageModule.model.users.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address map(AddressDTO addressDTO);

    AddressDTO map(Address address);
}
