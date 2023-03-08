package lk.easycarRental.service.impl;

import lk.easycarRental.dto.BookingDTO;
import lk.easycarRental.entity.Booking;
import lk.easycarRental.repo.BookingRepo;
import lk.easycarRental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveBookings(BookingDTO dto) {
        String s = generateBookingId();
        dto.setBookingID(s);
        repo.save(mapper.map(dto, Booking.class));
    }

    @Override
    public void deleteBookings(String vehicleNum) {

    }

    @Override
    public void updateBookings(BookingDTO dto) {

    }

    @Override
    public ArrayList<BookingDTO> getAllBookings() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<BookingDTO>>(){}.getType());
    }

    @Override
    public String generateBookingId() {
        long l = repo.countAllBy();
        return "BOID-"+(l+1);

    }


}
