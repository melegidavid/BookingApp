package proj.xmlws.MessageModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.MessageModule.dto.MessageDTO;
import proj.xmlws.MessageModule.service.MessageService;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessage(@PathVariable("id") Long messageId) {
        return ResponseEntity.ok(messageService.getMessage(messageId));
    }

    @GetMapping("/byReservation/{id}")
    public ResponseEntity<?> getMessagesByReservation(@PathVariable("id") Long reservationId) {
        return ResponseEntity.ok(messageService.getMessagesByReservation(reservationId));
    }

    @PutMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageService.sendMessage(messageDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> respondMessage(@PathVariable("id") Long messageId, @RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageService.respondToMessage(messageId, messageDTO));
    }

}
