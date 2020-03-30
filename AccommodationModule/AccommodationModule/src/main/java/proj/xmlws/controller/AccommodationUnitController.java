package proj.xmlws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.dto.AccommodationUnitDTO;
import proj.xmlws.dto.PeriodPriceDTO;
import proj.xmlws.dto.PeriodPriceDatesDTO;
import proj.xmlws.service.AccommodationUnitService;
import proj.xmlws.service.PeriodPriceService;

@RestController
@RequestMapping("/accommodation/units")
public class AccommodationUnitController {

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Autowired
    private PeriodPriceService periodPriceService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccommodationUnit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationUnitService.findAccommodationUnit(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccommodationUnit(@PathVariable("id") Long accommodationUnitId,@RequestBody AccommodationUnitDTO accommodationUnitDTO){
        return ResponseEntity.ok(accommodationUnitService.updateAccommodationUnit(accommodationUnitId, accommodationUnitDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAccommodationUnit(@PathVariable("id") Long accommodationUnitId) {
        return ResponseEntity.ok(accommodationUnitService.removeAccommodationUnit(accommodationUnitId));
    }

//    ***************************************************************************************************
//                                    PERIOD PRICES
//    ***************************************************************************************************

    @GetMapping("/{id}/prices")
    public ResponseEntity<?> getPeriodPrices(@PathVariable("id") Long accommodationUnitId) {
        return ResponseEntity.ok(periodPriceService.getAllPeriodPrices(accommodationUnitId));
    }

    @PostMapping("/{id}/prices")
    public ResponseEntity<?> addPeriodPrice(@PathVariable("id") Long accommodationUnitId,
                                            @RequestBody PeriodPriceDTO periodPriceDTO) {
        return ResponseEntity.ok(periodPriceService.savePeriodPrice(accommodationUnitId, periodPriceDTO));
    }

    @PutMapping("/prices/{id}")
    public ResponseEntity<?> updatePeriodPrice(@PathVariable("id") Long periodPriceId,
                                               @RequestBody PeriodPriceDTO periodPriceDTO) {
        return ResponseEntity.ok(periodPriceService.updatePeriodPrice(periodPriceId,periodPriceDTO));
    }

    @DeleteMapping("/prices/{id}")
    public ResponseEntity<?> removePeriodPrice(@PathVariable("id") Long periodPriceId) {
        return ResponseEntity.ok(periodPriceService.removePeriodPrice(periodPriceId));
    }

    @GetMapping("/{id}/priceForMonth")
    public ResponseEntity<?> getPriceForMonth(@PathVariable("id") Long accommodationUnitId,
                                              @RequestBody PeriodPriceDatesDTO periodPriceDatesDTO) {
        return ResponseEntity.ok(periodPriceService.getPeriodPriceForMonth(accommodationUnitId, periodPriceDatesDTO));
    }
}
