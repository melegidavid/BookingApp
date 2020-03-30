package proj.xmlws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.dto.ServiceDTO;
import proj.xmlws.service.ServiceService;

@RestController
@RequestMapping(value = "/accommodation/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getService(@PathVariable("id") Long serviceId) {
        return ResponseEntity.ok(serviceService.findService(serviceId));
    }

    @PostMapping
    public ResponseEntity<?> addService(@RequestBody ServiceDTO serviceDTO) {
        return ResponseEntity.ok(serviceService.saveService(serviceDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(@PathVariable("id") Long serviceId, @RequestBody ServiceDTO serviceDTO) {
        return ResponseEntity.ok(serviceService.updateService(serviceId,serviceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeService(@PathVariable("id") Long serviceId) {
        return ResponseEntity.ok(serviceService.removeService(serviceId));
    }
}
