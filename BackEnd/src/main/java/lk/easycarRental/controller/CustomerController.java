package lk.easycarRental.controller;

import lk.easycarRental.dto.CustomerDTO;
import lk.easycarRental.entity.Customer;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.service.CustomerService;
import lk.easycarRental.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService service;
    /*@Autowired
    private ModelMapper mapper;*/

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) {
        /*repo.save(mapper.<Customer>map(dto,Customer.class));
        return new ResponseUtil("ok","successfully added",null);*/
        service.saveCustomer(dto);
        return new ResponseUtil("ok", "successfully added",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil("ok","successfully loaded",service.getAllCustomers());
    }
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestParam String id){
        service.deleteCustomer(id);
        return new ResponseUtil("ok","successfully deleted",null);
    }
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("ok","successfully updated",null);
    }

}
