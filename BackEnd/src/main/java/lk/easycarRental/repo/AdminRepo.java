package lk.easycarRental.repo;

import lk.easycarRental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findAdminByAdminNic(String adminNic);
}
