package lk.easycarRental.controller;



import lk.easycarRental.dto.DriverDTO;
import lk.easycarRental.entity.Driver;
import lk.easycarRental.service.DriverService;
import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService service;
    /*@Autowired
    private ModelMapper mapper;*/

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto) {
        /*repo.save(mapper.<Customer>map(dto,Customer.class));
        return new ResponseUtil("ok","successfully added",null);*/
        service.saveDriver(dto);
        return new ResponseUtil("ok", "successfully added",null);
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){

        return new ResponseUtil("ok","successfully loaded",service.getAllDrivers());
    }

    @DeleteMapping
    public ResponseUtil deleteDriver(@RequestParam String licenceNum){
        service.deleteDriver(licenceNum);
        return new ResponseUtil("ok","successfully deleted",null);
    }
    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("ok","successfully updated",null);
    }

    @RequestMapping(value = "/findRandom", method = RequestMethod.GET)
    public ResponseUtil getDriverRandomly(@RequestParam String date1, @RequestParam String date2){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt1 = LocalDate.parse(date1,dateTimeFormatter);
        LocalDate dt2 = LocalDate.parse(date2,dateTimeFormatter);
        DriverDTO data = service.findDriverRandomly(dt1,dt2);
        return new ResponseUtil("OK","Successful!",data);
    }

    @GetMapping(params = {"licenceNum"})
    public ResponseUtil searchDriver(String licenceNum){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchDriver(licenceNum));
    }



}
