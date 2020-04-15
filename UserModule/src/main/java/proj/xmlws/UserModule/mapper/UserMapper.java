package proj.xmlws.UserModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.UserModule.dto.UserDTO;
import proj.xmlws.UserModule.model.users.User;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, AccommodationMapper.class})
public interface UserMapper {

    User map(UserDTO userDTO);

    UserDTO map(User user);
}
