package proj.xmlws.UserModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.xmlws.UserModule.model.reservation.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
