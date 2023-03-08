package lk.easycarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String  vehicalNo;
    private String brand;
    private String type;
    private int noOfPassenger;
    private String transmissionType;
    private String fuelType;
    private BigDecimal monthlyPrice;
    private BigDecimal dailyPrice;
    private BigDecimal priceForExtraKM;
    private BigDecimal lossDamageWaiver;
    private int mileage;
    private int serviceMileage;
    private String color;
    private boolean availability;

    private byte[] img_front;
    private byte[] img_back;
    private byte[] img_side;
    private byte[] img_interior;
}
