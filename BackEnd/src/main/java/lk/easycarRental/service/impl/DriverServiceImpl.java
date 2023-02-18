package lk.easycarRental.service.impl;


import lk.easycarRental.dto.DriverDTO;

import lk.easycarRental.entity.Driver;
import lk.easycarRental.repo.CustomerRepo;
import lk.easycarRental.repo.DriverRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class DriverServiceImpl {
    @Autowired
    private DriverRepo repo;
    @Autowired
    private ModelMapper mapper;
    public void saveDriver(DriverDTO dto) {
        repo.save(mapper.map(dto, Driver.class));
    }
}

