package proj.xmlws.MessageModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.MessageModule.model.accommodation.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("SELECT a FROM Accommodation a WHERE a.deleted = 0 AND a.id = :accommodationId")
    Accommodation findAccommodation(@Param("accommodationId")Long accommodationId);
}
