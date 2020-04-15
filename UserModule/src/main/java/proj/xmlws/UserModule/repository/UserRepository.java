package proj.xmlws.UserModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.UserModule.model.users.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE s.id = :userId AND u.deleted = 0")
    User findUser(@Param("userId") Long userId);

    @Query("SELECT u FROM User u WHERE s.username = :username AND u.deleted = 0")
    User findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE s.deleted = 0")
    List<User> getAllUsers();
}
