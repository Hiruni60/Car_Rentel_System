package lk.easycarRental.controller;

import lk.easycarRental.dto.BookingDTO;
import lk.easycarRental.service.BookingService;
import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseUtil saveCar(@RequestBody BookingDTO dto/*, @ModelAttribute MultipartFile img*/){


        service.saveBookings(dto);
        return new ResponseUtil("ok","successfully added",null);
    }
    @GetMapping
    public ResponseUtil getAllCars(){
        System.out.println("get all cars");
        return new ResponseUtil("ok","successfully loaded",service.getAllBookings());

    }
}
