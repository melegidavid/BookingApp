package proj.xmlws.UserModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.UserModule.dto.AddressDTO;
import proj.xmlws.UserModule.service.AddressService;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable("id") Long addressId) {
        return ResponseEntity.ok(addressService.findAddress(addressId));
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.saveAddress(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long addressId, @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.updateAddress(addressId,addressDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable("id") Long addressId) {
        return ResponseEntity.ok(addressService.removeAddress(addressId));
    }
}
