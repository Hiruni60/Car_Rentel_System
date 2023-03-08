package lk.easycarRental.service.impl;


import lk.easycarRental.dto.DriverDTO;

import lk.easycarRental.entity.Driver;
import lk.easycarRental.repo.DriverRepo;
import lk.easycarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;


@Service
@Transactional

public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;
    @Autowired
    private ModelMapper mapper;

   public void saveDriver(DriverDTO dto) {
//
        repo.save(mapper.map(dto, Driver.class));
//        if (repo.existsById(dto.getLicenceNum())){
//            throw new RuntimeException("Driver Already Exist. Please enter another id..!");
//        }
//        repo.save(mapper.map(dto, Driver.class));
//
//
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
    public DriverDTO findDriverRandomly(LocalDate date1 , LocalDate date2) {
        return mapper.map(repo.selectDriverRandomly(date1 ,date2),DriverDTO.class);
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

