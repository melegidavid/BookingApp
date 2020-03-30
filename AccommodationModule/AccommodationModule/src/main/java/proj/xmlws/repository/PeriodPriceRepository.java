package proj.xmlws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.xmlws.model.accommodation.PeriodPrice;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PeriodPriceRepository extends JpaRepository<PeriodPrice,Long> {

    @Query("SELECT pp FROM PeriodPrice pp WHERE pp.accommodationUnit.id = :accommodationUnitId AND pp.deleted = 0")
    List<PeriodPrice> getAllPeriodPrices(@Param("accommodationUnitId") Long accommodationUnitId);

    @Query("SELECT pp FROM PeriodPrice pp WHERE pp.accommodationUnit.id = :accommodationUnitId " +
            "AND pp.deleted = 0 AND MONTH(pp.fromDate) = MONTH(:fromDate)")
    PeriodPrice getPeriodPriceForMonth(@Param("accommodationUnitId") Long accommodationUnitId,
                                       @Param("fromDate")LocalDate fromDate);
}
