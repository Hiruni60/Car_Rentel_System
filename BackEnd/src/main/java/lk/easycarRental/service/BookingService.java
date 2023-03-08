package lk.easycarRental.service;

import lk.easycarRental.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {
    public void saveBookings(BookingDTO dto/*, MultipartFile img*/);
    public void deleteBookings(String vehicleNum);
    public void updateBookings(BookingDTO dto);
    public ArrayList<BookingDTO> getAllBookings();
    String generateBookingId();


}
