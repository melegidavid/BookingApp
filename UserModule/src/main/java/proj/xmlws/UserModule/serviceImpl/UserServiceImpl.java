package proj.xmlws.UserModule.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proj.xmlws.UserModule.dto.*;
import proj.xmlws.UserModule.enums.Role;
import proj.xmlws.UserModule.exception.UserException;
import proj.xmlws.UserModule.mapper.ReservationMapper;
import proj.xmlws.UserModule.mapper.UserMapper;
import proj.xmlws.UserModule.model.reservation.Reservation;
import proj.xmlws.UserModule.model.users.User;
import proj.xmlws.UserModule.repository.ReservationRepository;
import proj.xmlws.UserModule.repository.UserRepository;
import proj.xmlws.UserModule.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public boolean isRegistered(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist.");
        else
            return true;
    }

    @Override
    public boolean registerUser(UserDTO userDTO) {
        if(isRegistered(userDTO.getUsername()))
            throw new UserException(HttpStatus.CONFLICT, "User with that username already exist.");
        userRepository.save(userMapper.map(userDTO));
        return true;
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if(user.getPassword().equals(loginDTO.getPassword()) && user.getRole() == loginDTO.getRole())
            return userMapper.map(user);
        else
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist.");
    }

    @Override
    public UserListDTO getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        UserListDTO userListDTO = new UserListDTO();
        if(userList.isEmpty())
            return userListDTO;
        else {
            for(User u : userList)
                userListDTO.getUserDTOList().add(userMapper.map(u));
            return userListDTO;
        }
    }

    @Override
    public boolean updateUser(Long userId, UserDTO userDTO) {
        if(!isRegistered(userDTO.getUsername()))
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist.");
        User user = userRepository.getOne(userId);
        user = userMapper.map(userDTO);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean removeUser(String username) {
        if(!isRegistered(username))
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist.");
        User user = userRepository.findByUsername(username);
        user.setDeleted(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user != null && user.isEnabled() && !user.isBlocked())
           return userMapper.map(user);
        else
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
    }

    @Override
    public boolean activateUser(Long userId) {
        User user = userRepository.findUser(userId);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        user.setEnabled(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean blockUser(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        user.setBlocked(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean unblockUser(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        user.setBlocked(false);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean changeRole(String username,String role) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        if(role.equals("ADMIN"))
            user.setRole(Role.ADMINISTRATOR);
        else if(role.equals("AGENT"))
            user.setRole(Role.AGENT);
        else
            throw new UserException(HttpStatus.BAD_REQUEST, "That role doesn't exist.");
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean changePassword(ChangePasswordDTO changePasswordDTO){
        User user = userRepository.findByUsername(changePasswordDTO.getUsername());
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        if(!user.getPassword().equals(changePasswordDTO.getOldPassword()))
            return false;
        user.setPassword(changePasswordDTO.getNewPassword());
        userRepository.save(user);
        return true;
    }

    @Override
    public ReservationListDTO getUserReservations(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UserException(HttpStatus.NOT_FOUND, "User doesn't exist");
        List<Reservation> reservationList = reservationRepository.getUserReservations(user.getId());
        ReservationListDTO reservationListDTO = new ReservationListDTO();
        if(!reservationList.isEmpty()) {
            for(Reservation r : reservationList) {
                reservationListDTO.getReservationDTOList().add(reservationMapper.map(r));
            }
        }
        return reservationListDTO;
    }

}
