package proj.xmlws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.dto.AccommodationDTO;
import proj.xmlws.dto.AccommodationSearchDTO;
import proj.xmlws.dto.AccommodationUnitDTO;
import proj.xmlws.service.AccommodationService;
import proj.xmlws.service.AccommodationUnitService;
import proj.xmlws.service.ServiceService;


@RestController
@RequestMapping(value = "accommodation")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<?> getAllAccommodations() {
        return ResponseEntity.ok(accommodationService.findAllAccommodations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccommodation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationService.findAccommodation(id));
    }

    @PostMapping
    public ResponseEntity<?> addAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        return ResponseEntity.ok(accommodationService.saveAccommodation(accommodationDTO));
    }

    @PutMapping
    public ResponseEntity<?> updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        return ResponseEntity.ok(accommodationService.updateAccommodation(accommodationDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> removeAccommodation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationService.removeAccommodation(id));
    }


//    ***************************************************************************************
//                            ACCOMMODATION UNITS
//    ***************************************************************************************

    @GetMapping("/{id}/units")
    public ResponseEntity<?> getAccommodationUnits(@PathVariable("id") Long accommodationId) {
        return ResponseEntity.ok(accommodationUnitService.getAllUnitsOfAccommodation(accommodationId));
    }

    @PostMapping("/{id}/freeUnits")
    public ResponseEntity<?> getFreeAccommodationUnits(@PathVariable("id") Long accommodationId, @RequestBody AccommodationSearchDTO accommodationSearchDTO) {
        return ResponseEntity.ok(accommodationUnitService.getFreeAccommodationUnits(accommodationSearchDTO, accommodationId));
    }

    @PostMapping("/{id}/units")
    public ResponseEntity<?> addAccommodationUnit(@PathVariable("id") Long accommodationId, @RequestBody AccommodationUnitDTO accommodationUnitDTO) {
        return ResponseEntity.ok(accommodationUnitService.saveAccommodationUnit(accommodationUnitDTO,accommodationId));
    }

//    ***************************************************************************************
//                            ACCOMMODATION SERVICES
//    ***************************************************************************************

    @GetMapping("/{id}/services")
    public ResponseEntity<?> getAccommodationServices(@PathVariable("id") Long accommodationId) {
        return ResponseEntity.ok(serviceService.getAccommodationServices(accommodationId));
    }

    @PostMapping("/{aId}/services/{sId}")
    public ResponseEntity<?> addAccommodationService(@PathVariable("aId") Long accommodationId,
                                                     @PathVariable("sId") Long serviceId) {
        return ResponseEntity.ok(accommodationService.addAccommodationService(accommodationId,serviceId));
    }

    @DeleteMapping("/{aId}/services/{sId}")
    public ResponseEntity<?> removeAccommodationService(@PathVariable("aId") Long accommodationId,
                                                        @PathVariable("sId") Long serviceId) {
        return ResponseEntity.ok(accommodationService.removeAccommodationService(accommodationId,serviceId));
    }
}
