package lk.easycarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String AdminNic;
    private String name;
    private String address;
    private String email;
    private String password;
    private String contactNum;
}
