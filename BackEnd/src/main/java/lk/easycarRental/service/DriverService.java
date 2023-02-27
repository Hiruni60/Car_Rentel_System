package lk.easycarRental.service;




import lk.easycarRental.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    public void saveDriver(DriverDTO dto);
    public void deleteDriver(String licenceNum);
    public void updateDriver(DriverDTO dto);
    public DriverDTO searchDriver(String licenceNum);
    public ArrayList<DriverDTO> getAllDrivers();
}
