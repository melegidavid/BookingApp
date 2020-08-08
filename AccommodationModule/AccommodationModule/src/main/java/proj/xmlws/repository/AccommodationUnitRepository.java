package proj.xmlws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.model.accommodation.AccommodationUnit;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long> {

    @Query("SELECT au FROM AccommodationUnit au WHERE au.deleted = 0")
    List<AccommodationUnit> getAllAccommodationUnits();

    @Query("SELECT au FROM AccommodationUnit au WHERE au.accommodation.id = :accommodationId AND au.deleted = 0")
    List<AccommodationUnit> getAllUnitsOfAccommodation(@Param("accommodationId")Long accommodationId);

    @Query("SELECT au FROM Reservation r inner join r.accommodationUnit au " +
            "WHERE r.accommodationUnit.id = au.id " +
            "AND au.accommodation.id = :accommodationId " +
            "AND r.toDate < :fromDate OR r.fromDate > :toDate " +
            "AND r.deleted = 0 AND au.deleted = 0")
    List<AccommodationUnit> getFreeAccommodationUnits(@Param("fromDate")LocalDate fromDate,
                                                      @Param("toDate")LocalDate toDate,
                                                      @Param("accommodationId") Long accommodationId);
}
