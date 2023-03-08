package lk.easycarRental.controller;




import lk.easycarRental.dto.CarDTO;
import lk.easycarRental.service.CarService;

import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseUtil saveCar(
            @RequestParam String vehicalNo,
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam int noOfPassenger,
            @RequestParam int mileage,
            @RequestParam int serviceMileage,
            @RequestParam String transmissionType,
            @RequestParam String fuelType,
            @RequestParam BigDecimal dailyPrice,
            @RequestParam BigDecimal monthlyPrice,
            @RequestParam BigDecimal priceForExtraKM,
            @RequestParam BigDecimal lossDamageWaiver,
            @RequestParam String color,
            @RequestParam boolean availability,
            @RequestPart("file1") MultipartFile file1,
            @RequestPart("file2") MultipartFile file2,
            @RequestPart("file3") MultipartFile file3,
            @RequestPart("file4") MultipartFile file4
    ) throws IOException {

        CarDTO dto = new CarDTO(vehicalNo,brand,type,noOfPassenger,transmissionType,fuelType,monthlyPrice,dailyPrice,priceForExtraKM,lossDamageWaiver,mileage,serviceMileage,color,availability,file1.getBytes(),file2.getBytes(),file3.getBytes(),file4.getBytes());
        service.saveCar(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseUtil updateCar(
            @RequestParam String vehicalNo,
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam int noOfPassenger,
            @RequestParam int mileage,
            @RequestParam int serviceMileage,
            @RequestParam String transmissionType,
            @RequestParam String fuelType,
            @RequestParam BigDecimal dailyPrice,
            @RequestParam BigDecimal monthlyPrice,
            @RequestParam BigDecimal priceForExtraKM,
            @RequestParam BigDecimal lossDamageWaiver,
            @RequestParam String color,
            @RequestParam boolean availability,
            @RequestPart(name = "file1", required = false) MultipartFile file1,
            @RequestPart(name = "file2",required = false) MultipartFile file2,
            @RequestPart(name = "file3",required = false) MultipartFile file3,
            @RequestPart(name = "file4",required = false) MultipartFile file4
    ) throws IOException {

        CarDTO dto = new CarDTO(vehicalNo,brand,type,noOfPassenger,transmissionType,fuelType,monthlyPrice,dailyPrice,priceForExtraKM,lossDamageWaiver,mileage,serviceMileage,color,availability,file1.getBytes(),file2.getBytes(),file3.getBytes(),file4.getBytes());
        service.updateCar(dto);
        return new ResponseUtil("OK","Successfully Updated.!",null);

    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public ResponseUtil removeCar(@RequestParam String vehicalNo){
        service.deleteCar(vehicalNo);
        return new ResponseUtil("OK","Successfully Deleted.!",null);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseUtil getAllCar(){
        ArrayList<CarDTO> data = service.getAllCar();
        return new ResponseUtil("OK","Successful!",data);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseUtil getAllCar(@RequestParam String vehicalNo){
        //CarDTO data = service.findCarByVehicalNo(vehicalNo);
       // return new ResponseUtil("OK","Successful!",data);
        return null;
    }

    @RequestMapping(value = "/countCarsByAvailabilityIsTrue", method = RequestMethod.GET)
    public ResponseUtil countCarsByAvailabilityIsTrue(){
        return new ResponseUtil("OK","Successful!",service.countCarsByAvailabilityIsTrue());
    }

//    @RequestMapping(value = "/countCarsScheduled", method = RequestMethod.GET)
//    public ResponseUtil countCarsScheduled(){
//        return new ResponseUtil("OK","Successful!",CarService.countCarsScheduled());
//    }



}
