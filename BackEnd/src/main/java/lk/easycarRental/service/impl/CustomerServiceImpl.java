package lk.easycarRental.service.impl;

import lk.easycarRental.dto.CustomerDTO;
import lk.easycarRental.entity.Customer;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ModelMapper mapper;


    public void saveCustomer(CustomerDTO dto) {

        repo.save(mapper.map(dto,Customer.class));
    }


   @Override
    public void deleteCustomer(String nic) {
        if (!repo.existsById(nic)){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.deleteById(nic);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getNic())){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.save(mapper.map(dto,Customer.class));
    }


    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO searchCustomer(String nic) {
//        Optional<Customer> customer = repo.findById(NIC);
//        if (customer.isPresent()) {
//            return mapper.map(customer,CustomerDTO.class);
//        }
//        return null;
        if (!repo.existsById(nic)){
            throw new RuntimeException("invalid id");

        }
        Customer customer = repo.findCustomerByNic(nic);
        CustomerDTO map = mapper.map(customer,CustomerDTO.class);
        return map;
    }
}
