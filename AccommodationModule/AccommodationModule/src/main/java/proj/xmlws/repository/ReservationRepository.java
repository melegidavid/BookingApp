package proj.xmlws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.xmlws.model.reservation.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
