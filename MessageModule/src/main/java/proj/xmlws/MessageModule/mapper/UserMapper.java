package proj.xmlws.MessageModule.mapper;

import org.mapstruct.Mapper;
import proj.xmlws.MessageModule.dto.UserDTO;
import proj.xmlws.MessageModule.model.users.User;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, AccommodationMapper.class})
public interface UserMapper {

    User map(UserDTO userDTO);

    UserDTO map(User user);
}
