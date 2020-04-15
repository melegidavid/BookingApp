package proj.xmlws.UserModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.UserModule.model.reservation.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r WHERE r.guest.id = :userId AND r.deleted = 0")
    List<Reservation> getUserReservations(@Param("userId") Long userId);


}
