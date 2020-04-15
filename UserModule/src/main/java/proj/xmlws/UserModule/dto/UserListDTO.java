package proj.xmlws.UserModule.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {

    private List<UserDTO> userDTOList;

    public UserListDTO() {
        this.userDTOList = new ArrayList<>();
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }
}
