package lk.easycarRental.controller;

import lk.easycarRental.dto.AdminDTO;

import lk.easycarRental.service.AdminService;
import lk.easycarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto) {
        /*repo.save(mapper.<Customer>map(dto,Customer.class));
        return new ResponseUtil("ok","successfully added",null);*/
        service.saveAdmin(dto);
        return new ResponseUtil("ok", "successfully added",null);
    }

    @GetMapping
    public ResponseUtil getAllAdmin(){
        return new ResponseUtil("ok","successfully loaded",service.getAllAdmin());
    }
    @DeleteMapping
    public ResponseUtil deleteAdmin(@RequestParam String adminNic){
        service.deleteAdmin(adminNic);
        return new ResponseUtil("ok","successfully deleted",null);
    }
    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        service.updateAdmin(dto);
        return new ResponseUtil("ok","successfully updated",null);
    }

    @GetMapping(params = {"adminNic"})
    public ResponseUtil searchAdmin(String adminNic){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchAdmin(adminNic));
    }

}
