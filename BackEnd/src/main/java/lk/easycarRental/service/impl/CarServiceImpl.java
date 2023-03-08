package lk.easycarRental.service.impl;

import lk.easycarRental.dto.CarDTO;

import lk.easycarRental.entity.Car;

import lk.easycarRental.repo.CarRepo;
import lk.easycarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveCar(CarDTO dto){

        repo.save(mapper.map(dto, Car.class));
    }
    @Override
    public void deleteCar(String vehicalNo) {
        if (!repo.existsById(vehicalNo)){
            throw new RuntimeException("Wrong Registration Number..Please enter a valid number !");
        }
        repo.deleteById(vehicalNo);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getVehicalNo())){
            throw new RuntimeException("Car Doesn't Exist. Please Enter Valid identifier..!");
        }
        repo.save(mapper.map(dto, Car.class));
    }


    @Override
    public CarDTO findCarByVehicalNo(String vehicalNo) {
        return mapper.map(repo.findCarByVehicalNo(vehicalNo),CarDTO.class);


    }





    public ArrayList<CarDTO> getAllCar() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public int countCarsByAvailabilityIsTrue() {
        return repo.countCarsByAvailabilityIsTrue();
    }

//    @Override
//    public int countCarsScheduled() {
//        return repo.countCarsScheduled();
//    }
}
