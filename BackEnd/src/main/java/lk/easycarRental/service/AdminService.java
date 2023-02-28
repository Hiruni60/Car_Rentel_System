package lk.easycarRental.service;

import lk.easycarRental.dto.AdminDTO;
import lk.easycarRental.dto.CustomerDTO;

import java.util.ArrayList;

public interface AdminService {
    ArrayList<AdminDTO> getAllAdmin();

    void saveAdmin(AdminDTO dto);

    void deleteAdmin(String adminNic);

    void updateAdmin(AdminDTO dto);

    AdminDTO searchAdmin(String adminNic);
}
