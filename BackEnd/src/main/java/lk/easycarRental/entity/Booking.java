package lk.easycarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Booking {
    @Id
    private String bookingID;
    private LocalDate currentDate;
    private LocalDate dueDate;
    private BigDecimal advance;
    private String accepted;
    private BigDecimal total;

    @ManyToOne
    private Car car;
    @ManyToOne
    private Driver driver;
    /*@ManyToOne
    private Admin admin;*/
    @ManyToOne
    private Customer customer;


}
