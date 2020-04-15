package proj.xmlws.UserModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.xmlws.UserModule.dto.ChangePasswordDTO;
import proj.xmlws.UserModule.dto.LoginDTO;
import proj.xmlws.UserModule.dto.UserDTO;
import proj.xmlws.UserModule.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PutMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.loginUser(loginDTO));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userId,userDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.removeUser(username));
    }

    @PutMapping("/activate/{userId}")
    public ResponseEntity<?> activateUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.activateUser(userId));
    }

    @PutMapping("/block/{username}")
    public ResponseEntity<?> blockUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.blockUser(username));
    }

    @PutMapping("/unblock/{username}")
    public ResponseEntity<?> unblockUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.unblockUser(username));
    }

    @PutMapping("/{username}/{role}")
    public ResponseEntity<?> changeRole(@PathVariable("username") String username,
                                        @PathVariable ("role") String role) {
        return ResponseEntity.ok(userService.changeRole(username,role));
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        return ResponseEntity.ok(userService.changePassword(changePasswordDTO));
    }

    @GetMapping("/{username}/reservations")
    public ResponseEntity<?> getUserReservations(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.getUserReservations(username));
    }



}
