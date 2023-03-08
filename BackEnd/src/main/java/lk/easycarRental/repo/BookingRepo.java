package lk.easycarRental.repo;

import lk.easycarRental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
