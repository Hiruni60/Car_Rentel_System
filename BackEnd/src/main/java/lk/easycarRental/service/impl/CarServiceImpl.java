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
    public void deleteCar(String id) {
        if (!repo.existsById(id)){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.deleteById(id);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getVehicalNo())){
            throw new RuntimeException("Wrong nic..Please Check the nic");
        }
        repo.save(mapper.map(dto, Car.class));
    }


    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

}
