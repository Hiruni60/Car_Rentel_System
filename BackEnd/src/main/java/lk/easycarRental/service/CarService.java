package lk.easycarRental.service;

import lk.easycarRental.dto.CarDTO;
import lk.easycarRental.dto.DriverDTO;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO dto);

    void deleteCar(String id);

    void updateCar(CarDTO dto);

    ArrayList<CarDTO> getAllCars();
}
