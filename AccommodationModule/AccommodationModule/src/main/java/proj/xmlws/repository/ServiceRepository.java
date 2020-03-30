package proj.xmlws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.model.accommodation.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s FROM Service s WHERE s.deleted = 0")
    List<Service> getAllServices();

    @Query("SELECT s FROM Service s join s.accommodation a WHERE a.id = :accommodationId")
    List<Service> getAccommodationServices(@Param("accommodationId")Long accommodationId);
}
