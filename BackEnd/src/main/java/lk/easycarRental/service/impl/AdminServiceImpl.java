package lk.easycarRental.service.impl;

import lk.easycarRental.dto.AdminDTO;

import lk.easycarRental.entity.Admin;
import lk.easycarRental.repo.AdminRepo;

import lk.easycarRental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveAdmin(AdminDTO dto) {

        repo.save(mapper.map(dto, Admin.class));
    }


    @Override
    public void deleteAdmin(String adminNic) {
        if (!repo.existsById(adminNic)){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.deleteById(adminNic);
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminNic())){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.save(mapper.map(dto,Admin.class));
    }


    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<AdminDTO>>(){}.getType());
    }

    @Override
    public AdminDTO searchAdmin(String adminNic) {
//        Optional<Customer> customer = repo.findById(NIC);
//        if (customer.isPresent()) {
//            return mapper.map(customer,CustomerDTO.class);
//        }
//        return null;
        if (!repo.existsById(adminNic)){
            throw new RuntimeException("invalid id");

        }
        Admin admin = repo.findAdminByAdminNic(adminNic);
        AdminDTO map = mapper.map(admin,AdminDTO.class);
        return map;
    }

}
