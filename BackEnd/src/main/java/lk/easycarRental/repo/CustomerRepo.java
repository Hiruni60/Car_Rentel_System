package lk.easycarRental.repo;

import lk.easycarRental.config.JPAConfig;
import lk.easycarRental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
