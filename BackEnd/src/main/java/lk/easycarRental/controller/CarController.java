package lk.easycarRental.controller;


import lk.easycarRental.dto.CarDTO;
import lk.easycarRental.dto.DriverDTO;
import lk.easycarRental.service.CarService;
import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin

public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto) {
        /*repo.save(mapper.<Customer>map(dto,Customer.class));
        return new ResponseUtil("ok","successfully added",null);*/
        service.saveCar(dto);
        return new ResponseUtil("ok", "successfully added",null);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        return new ResponseUtil("ok","successfully loaded",service.getAllCars());
    }
    @DeleteMapping
    public ResponseUtil deleteCar(@RequestParam String id){
        service.deleteCar(id);
        return new ResponseUtil("ok","successfully deleted",null);
    }
    @PutMapping
    public ResponseUtil updateCarr(@RequestBody CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("ok","successfully updated",null);
    }
}
