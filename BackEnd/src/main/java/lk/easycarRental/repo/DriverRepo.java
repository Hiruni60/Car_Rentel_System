package lk.easycarRental.repo;


import lk.easycarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByLicenceNum(String licenceNum);
}
