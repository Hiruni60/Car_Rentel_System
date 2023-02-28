package lk.easycarRental.repo;

import lk.easycarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    Car findCarByVehicalNo(String vehicalNo);

    //available cars
    int countCarsByAvailabilityIsTrue();
//
//    //cars scheduled
//    @Query(value = "select COUNT(*) from Car INNER JOIN Booking ON Car .vehicalNo=Booking.car_vehicalNo", nativeQuery = true){
//        int countCarsScheduled();
//    }
}

