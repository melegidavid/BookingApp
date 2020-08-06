package proj.xmlws.MessageModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.MessageModule.model.reservation.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.deleted = 0 AND m.id = :messageId")
    Message findMessage(@Param("messageId") Long messageId);

    @Query("SELECT m FROM Message m WHERE m.deleted = 0 AND m.reservation.id = :reservationId")
    List<Message> getAllMessagesOfReservation(@Param("reservationId")Long reservationId);

}
