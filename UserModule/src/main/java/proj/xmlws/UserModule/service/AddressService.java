package proj.xmlws.UserModule.service;


import proj.xmlws.UserModule.dto.AddressDTO;
import proj.xmlws.UserModule.dto.AddressListDTO;

public interface AddressService {

    AddressListDTO findAllAddresses();

    AddressDTO findAddress(Long addressId);

    boolean saveAddress(AddressDTO addressDTO);

    boolean updateAddress(Long addressId, AddressDTO addressDTO);

    boolean removeAddress(Long addressId);
}
