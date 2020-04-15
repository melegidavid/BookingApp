package proj.xmlws.UserModule.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressListDTO {

    private List<AddressDTO> addressDTOList;

    public AddressListDTO() {
        this.addressDTOList = new ArrayList<>();
    }

    public List<AddressDTO> getAddressDTOList() {
        return addressDTOList;
    }

    public void setAddressDTOList(List<AddressDTO> addressDTOList) {
        this.addressDTOList = addressDTOList;
    }
}
