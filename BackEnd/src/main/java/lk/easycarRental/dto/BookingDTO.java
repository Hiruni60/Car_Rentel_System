package lk.easycarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BookingDTO {
    private String bookingID;
    private LocalDate currentDate;
    private LocalDate dueDate;
    private BigDecimal advance;

    private String accepted;
    private BigDecimal total;

    private CarDTO car;
    private DriverDTO driver;
    private CustomerDTO customer;
}
