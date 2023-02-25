package lk.easycarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String vehicalNo;
    private String brand;
    private String type;
    private int noOfPassenger;
    private String transmissionType;
    private String fuelType;
    private BigDecimal monthlyPrice;
    private BigDecimal dailyPrice;
    private BigDecimal priceForExtraKM;
    private String colour;
    private boolean available;
}
