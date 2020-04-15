package proj.xmlws.UserModule.service;

import proj.xmlws.UserModule.dto.*;

public interface UserService {

    boolean isRegistered(String username);

    boolean registerUser(UserDTO userDTO);

    UserDTO loginUser(LoginDTO loginDTO);

    UserListDTO getAllUsers();

    boolean updateUser(Long userId, UserDTO userDTO);

    boolean removeUser(String username);

    UserDTO getUserByUsername(String username);

    boolean activateUser(Long userId);

    boolean blockUser(String username);

    boolean unblockUser(String username);

    boolean changeRole(String username, String role);

    boolean changePassword(ChangePasswordDTO changePasswordDTO);

    ReservationListDTO getUserReservations(String username);
}
