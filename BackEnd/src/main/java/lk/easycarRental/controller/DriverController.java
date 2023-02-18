package lk.easycarRental.controller;


import lk.easycarRental.dto.DriverDTO;
import lk.easycarRental.service.DriverService;
import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
