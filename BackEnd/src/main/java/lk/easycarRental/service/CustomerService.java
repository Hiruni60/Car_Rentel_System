package lk.easycarRental.service;

import lk.easycarRental.dto.CustomerDTO;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto);
    public void deleteCustomer(String id);
}
