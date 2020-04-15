package proj.xmlws.UserModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.xmlws.UserModule.model.accommodation.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
}
