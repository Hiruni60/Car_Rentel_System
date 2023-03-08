package lk.easycarRental.repo;

import lk.easycarRental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepo extends JpaRepository<Booking,String> {
    @Modifying
    @Query(value = "UPDATE Booking p SET p.isAccepted=true  WHERE p.bookingId=:id",nativeQuery = true)
    void acceptBooking(@Param("id") String id);

    long countAllBy();
}
