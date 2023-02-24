package lk.easycarRental.service;



import lk.easycarRental.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    public void saveDriver(DriverDTO dto);
    public void deleteDriver(String id);
    public void updateDriver(DriverDTO dto);
    public ArrayList<DriverDTO> getAllDrivers();
}
