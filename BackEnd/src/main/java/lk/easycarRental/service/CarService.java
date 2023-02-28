package lk.easycarRental.service;

import lk.easycarRental.dto.CarDTO;


import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO dto);

    void deleteCar(String vehicalNo);

    void updateCar(CarDTO dto);

    ArrayList<CarDTO> findCarByVehicalNo();

    int countCarsByAvailabilityIsTrue();

    ArrayList<CarDTO> getAllCar();


    // int countCarsScheduled();
}
