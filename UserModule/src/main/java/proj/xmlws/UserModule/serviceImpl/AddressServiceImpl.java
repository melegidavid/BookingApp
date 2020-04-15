package proj.xmlws.UserModule.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.UserModule.dto.AddressDTO;
import proj.xmlws.UserModule.dto.AddressListDTO;
import proj.xmlws.UserModule.exception.UserException;
import proj.xmlws.UserModule.mapper.AddressMapper;
import proj.xmlws.UserModule.model.users.Address;
import proj.xmlws.UserModule.repository.AddressRepository;
import proj.xmlws.UserModule.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public AddressListDTO findAllAddresses() {
        List<Address> addressList = addressRepository.findAllAdresses();
        AddressListDTO addressListDTO = new AddressListDTO();
        if(!addressList.isEmpty()) {
            for(Address a : addressList) {
                addressListDTO.getAddressDTOList().add(addressMapper.map(a));
            }
            return addressListDTO;
        } else {
            return new AddressListDTO();
        }
    }

    @Override
    public AddressDTO findAddress(Long addressId) {
        Address address = addressRepository.getOne(addressId);
        if(address.isDeleted() || address == null) {
            throw new UserException(HttpStatus.NOT_FOUND, "Address doesn't exist.");
        } else {
            return addressMapper.map(address);
        }
    }

    @Override
    public boolean saveAddress(AddressDTO addressDTO) {
        Address address = addressMapper.map(addressDTO);
        addressRepository.save(address);
        return true;
    }

    @Override
    public boolean updateAddress(Long addressId, AddressDTO addressDTO) {
        Address address = addressRepository.getOne(addressId);
        if(address.isDeleted() || address == null) {
            throw new UserException(HttpStatus.NOT_FOUND, "Address doesn't exist.");
        } else {
            address = addressMapper.map(addressDTO);
            addressRepository.save(address);
            return true;
        }
    }

    @Override
    public boolean removeAddress(Long addressId) {
        Address address = addressRepository.getOne(addressId);
        if(address.isDeleted() || address == null) {
            throw new UserException(HttpStatus.NOT_FOUND, "Address doesn't exist");
        } else {
            address.setDeleted(true);
            addressRepository.save(address);
            return true;
        }
    }
}
