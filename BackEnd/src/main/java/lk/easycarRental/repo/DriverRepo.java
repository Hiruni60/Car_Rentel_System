package lk.easycarRental.repo;


import lk.easycarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByLicenceNum(String licenceNum);
    @Query(value = "select * from Driver WHERE Driver.licenceNum NOT IN (select Booking.driver_licenceNum from Booking) OR Driver.licenceNum NOT IN (select Booking.driver_licenceNum from Booking where :date1 between Booking.currentDate and Booking.dueDate) AND Driver.licenceNum NOT IN (select Booking.driver_licenceNum from Booking where :date2 between Booking.currentDate and Booking.dueDate) ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Driver selectDriverRandomly(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2 );
    @Query(value = "select COUNT(*) from Driver INNER JOIN Booking ON Driver.username = Booking.driver_username WHERE CURDATE() between Booking.currenDateTime and Booking.dueDateTime",nativeQuery = true)
    int getNoOfOccupiedDrivers();
    @Query(value = "select COUNT(*) from Driver INNER JOIN Booking ON Driver.username = Booking.driver_username WHERE CURDATE() NOT between Booking.currenDateTime and Booking.dueDateTime",nativeQuery = true)
    int getNoOfAvailableDrivers();
}
