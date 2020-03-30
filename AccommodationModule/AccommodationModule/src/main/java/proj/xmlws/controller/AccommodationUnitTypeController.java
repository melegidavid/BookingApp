package proj.xmlws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.dto.AccommodationUnitTypeDTO;
import proj.xmlws.service.AccommodationUnitTypeService;

@RestController
@RequestMapping("/accommodationUnitType")
public class AccommodationUnitTypeController {

    @Autowired
    private AccommodationUnitTypeService accommodationUnitTypeService;

    @GetMapping
    public ResponseEntity<?> getAllAccommodationUnitTypes() {
        return ResponseEntity.ok(accommodationUnitTypeService.getAllAccommodationUnitTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccommodationUnitType(@PathVariable("id") Long accommodationUnitTypeId) {
        return ResponseEntity.ok(accommodationUnitTypeService.findAccommodationUnitType(accommodationUnitTypeId));
    }

    @PostMapping
    public ResponseEntity<?> addAccommodationUnitType(AccommodationUnitTypeDTO accommodationUnitTypeDTO) {
        return ResponseEntity.ok(accommodationUnitTypeService.saveAccommodationUnitType(accommodationUnitTypeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccommodationUnitType(@PathVariable("id") Long accommodationUnitTypeId,
                                                         @RequestBody AccommodationUnitTypeDTO accommodationUnitTypeDTO) {
        return ResponseEntity.ok(accommodationUnitTypeService.updateAccommodationUnitType(accommodationUnitTypeId, accommodationUnitTypeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAccommodationUnitType(@PathVariable("id") Long accommodationUnitTypeId) {
        return ResponseEntity.ok(accommodationUnitTypeService.removeAccommodationUnitType(accommodationUnitTypeId));
    }
}
