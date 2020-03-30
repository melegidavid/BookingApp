package proj.xmlws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proj.xmlws.model.accommodation.AccommodationUnitType;

import java.util.List;

@Repository
public interface AccommodationUnitTypeRepository extends JpaRepository<AccommodationUnitType,Long> {

    @Query("SELECT aut FROM AccommodationUnitType aut WHERE aut.deleted = 0")
    List<AccommodationUnitType> getAllAccommodationUnitTypes();
}
