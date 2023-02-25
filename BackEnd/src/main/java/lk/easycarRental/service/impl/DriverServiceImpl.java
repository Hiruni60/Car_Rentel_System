package lk.easycarRental.service.impl;


import lk.easycarRental.dto.CustomerDTO;
import lk.easycarRental.dto.DriverDTO;

import lk.easycarRental.entity.Customer;
import lk.easycarRental.entity.Driver;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.repo.DriverRepo;
import lk.easycarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional

public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;
    @Autowired
    private ModelMapper mapper;
    public void saveDriver(DriverDTO dto) {
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String licenceNum) {
        if (!repo.existsById(licenceNum)){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.deleteById(licenceNum);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenceNum())){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.save(mapper.map(dto,Driver.class));
    }


    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO searchDriver(String licenceNum) {

        if (!repo.existsById(licenceNum)){
            throw new RuntimeException("invalid id");

        }
        Driver driver = repo.findDriverByLicenceNum(licenceNum);
        DriverDTO map = mapper.map(driver,DriverDTO.class);
        return map;
    }

}

