package lk.easycarRental.service;

import lk.easycarRental.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto);
    public void deleteCustomer(String nic);
    public void updateCustomer(CustomerDTO dto);
    public CustomerDTO searchCustomer(String nic);
    public ArrayList<CustomerDTO> getAllCustomers();
}
