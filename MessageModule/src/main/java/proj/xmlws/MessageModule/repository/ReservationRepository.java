package proj.xmlws.MessageModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.MessageModule.model.reservation.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.deleted = 0 AND r.id = :reservationId")
    Reservation findReservation(@Param("reservationId") Long reservationId);
}
