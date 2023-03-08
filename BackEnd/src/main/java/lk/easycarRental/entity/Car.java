package lk.easycarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
//    @Id
//    private String vehicalNo;
//    private String brand;
//    private String type;
//    private int noOfPassenger;
//    private String transmissionType;
//    private String fuelType;
//    private BigDecimal monthlyPrice;
//    private BigDecimal dailyPrice;
//    private BigDecimal priceForExtraKM;
//    private String colour;
//    private boolean available;

    @Id
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
    @Lob
    private byte[] img_front;
    @Lob
    private byte[] img_back;
    @Lob
    private byte[] img_side;
    @Lob
    private byte[] img_interior;

//    @OneToMany(mappedBy = "car")
//   private Collection<Booking> bookings = new ArrayList<>();

    public Car(String vehicalNo) {
        this.vehicalNo = vehicalNo;
    }
}
