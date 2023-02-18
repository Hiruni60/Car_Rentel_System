package lk.easycarRental.controller;

import lk.easycarRental.dto.CustomerDTO;
import lk.easycarRental.entity.Customer;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO dto){
        repo.save(mapper.<Customer>map(dto,Customer.class));
        return new ResponseUtil("ok","successfully added",null);
    }

}
