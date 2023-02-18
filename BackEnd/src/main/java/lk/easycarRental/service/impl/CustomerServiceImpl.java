package lk.easycarRental.service.impl;

import lk.easycarRental.dto.CustomerDTO;
import lk.easycarRental.entity.Customer;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ModelMapper mapper;
    public void saveCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto,Customer.class));
    }

    public void deleteCustomer(String id) {

    }
}
